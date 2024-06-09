package blonicx.servonapi.util;

import blonicx.servonapi.Servon_Api;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

import org.jsoup.select.Elements;
import org.yaml.snakeyaml.Yaml;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;


public class Servon_Api_Util {
    private static final String GITHUB_API_URL = "https://github.com/Blonicx/Servon-Api/releases/latest";
    private static int API_VERSION;

    {
        try {
            API_VERSION = Integer.valueOf(getCurrentVersion());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getCurrentVersion() throws IOException {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = Servon_Api.class.getResourceAsStream("/plugin.yml")) {
            if (inputStream == null) {
                throw new IOException("plugin.yml not found in the JAR.");
            }
            Map<String, Object> obj = yaml.load(inputStream);
            return (String) obj.get("version");
        }
    }

    class ApiCompability {
        public static boolean CheckCompability(int MinimumVersion){
            if (API_VERSION >= MinimumVersion){
                return true;
            }
            else{
                return false;
            }
        }
    }

    class Update {
        public static void CheckForUpdate() {
            try {
                String currentVersion = getCurrentVersion();
                String latestVersion = getLatestVersion();
                if (isUpdateAvailable(currentVersion, latestVersion)) {
                    System.out.println("Update available: " + latestVersion);
                    downloadLatestJar(latestVersion);
                } else {
                    System.out.println("No updates available.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        private static String getLatestVersion() throws IOException {
            Document doc = Jsoup.connect(GITHUB_API_URL).get();
            Elements releaseTags = doc.getElementsByClass("release-header");
            if (!releaseTags.isEmpty()) {
                Element latestReleaseTag = releaseTags.first();
                return latestReleaseTag.getElementsByTag("a").first().text();
            } else {
                throw new IOException("Latest release tag not found.");
            }
        }
        private static boolean isUpdateAvailable(String currentVersion, String latestVersion) {
            return !currentVersion.equals(latestVersion);
        }

        private static void downloadLatestJar(String version) throws IOException {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String downloadUrl = "https://github.com/Blonicx/Servon-Api/releases/download/" + version + "/Servon-Api.jar";
            HttpGet request = new HttpGet(downloadUrl);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    String errorMessage = EntityUtils.toString(response.getEntity());
                    throw new IOException("Failed to download JAR. HTTP Status: " + statusCode + ". Response: " + errorMessage);
                }

                HttpEntity entity = response.getEntity();
                try (InputStream inputStream = entity.getContent();
                     FileOutputStream outputStream = new FileOutputStream("Servon-Api.jar")) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
                System.out.println("Downloaded the latest version: " + version);
            }
        }
    }
}
