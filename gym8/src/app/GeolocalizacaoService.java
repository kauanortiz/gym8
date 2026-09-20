package app;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class GeolocalizacaoService {

	public static double[] buscarCoordenadas(String endereco) {
		try {
			String enderecoFormatado = URLEncoder.encode(endereco, StandardCharsets.UTF_8);
			
			String url = "https://nominatim.openstreetmap.org/search?q="
			+ enderecoFormatado + "&format=json&limit=1";
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.header("User-Agent", "AppGym8/1.0")
					.GET()
					.build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			String json = response.body();
			
			if(json != null && !json.equals("[]")) {
				String latString = json.split("\"lat\":\"")[1].split("\"")[0];
				String lonString = json.split("\"lon\":\"")[1].split("\"")[0];
				
				double latitude = Double.parseDouble(latString);
				double longitude = Double.parseDouble(lonString);
				
				return new double[] {latitude, longitude};
			}
		}
		catch(Exception e) {
			System.out.println("Erro ao buscar coordenadas: " + e.getMessage());
		}
		
		return null;		
	}	
}
