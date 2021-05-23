package br.com.dio.http;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;


public class HttpClientExample {
	
	static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {		
		@Override
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r);
			System.out.println("Thread criada: " 
					+ (thread.isDaemon()?"daemon":"") 
					+ "Thread gorup: " + thread.getThreadGroup());
			return thread;
		}
	});

	// conexão com http/1.1
	private static void connecAkanaiServertHttp11() throws Exception {
		System.out.println("Running example with HTTP/1.1");
		try {
			HttpClient client = HttpClient.newBuilder()
					.version(HttpClient.Version.HTTP_1_1)
					.proxy(ProxySelector.getDefault())
					.build();
			
			long start = System.currentTimeMillis();			
			
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html")).build();
			var response = client.send(request, HttpResponse.BodyHandlers.ofString());
			String responseBody = response.body();
			System.out.println(response.toString());
			
			List<Future<?>> future = new ArrayList<>();			
			
			responseBody
				.lines()
				.filter(line -> line.trim().startsWith("<img height"))
				.map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))
				.forEach(img -> {
					Future<?> imgFuture = executor.submit(() -> {
						HttpRequest imgRequest = HttpRequest.newBuilder()
							.uri(URI.create("https://http2.akamai.com"+img))
							.build();
						
						try {
							HttpResponse<String> imgResponse = client.send(imgRequest, HttpResponse.BodyHandlers.ofString());
							System.out.println("Img loaded:" +img + " status: " + imgResponse.statusCode());
						} catch (IOException | InterruptedException e) {
							System.out.println("erro na requisição para recuperar a imagem ' "+img+"'");
							e.printStackTrace();
						}
					});
					
					future.add(imgFuture);
					System.out.println("Future submitted to image: "+ img);
				});
			
			future.forEach(f -> {
				try {
					f.get();
				} catch (InterruptedException | ExecutionException e) {
					System.out.println("Error ao esperar a image carregar do Future");
					//e.printStackTrace();
				}
			});
			
			
			long end = System.currentTimeMillis();
			System.out.println("Tempo total HTTP/1.1: "+ (end-start) + "ms");
			
		//} catch (IOException e) {
		//	e.printStackTrace();
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		}finally {
			executor.shutdown();
		}
	}
	
	// teste com http/2
	private static void connecAkanaiServertHttp2() throws Exception {
		System.out.println("Running example with HTTP/2");
		try {
			HttpClient client = HttpClient.newBuilder()
					.version(HttpClient.Version.HTTP_2)
					.proxy(ProxySelector.getDefault())
					.build();
			
			long start = System.currentTimeMillis();			
			
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html")).build();
			var response = client.send(request, HttpResponse.BodyHandlers.ofString());
			String responseBody = response.body();
			System.out.println(response.toString());
			
			List<Future<?>> future = new ArrayList<>();			
			
			responseBody
				.lines()
				.filter(line -> line.trim().startsWith("<img height"))
				.map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))
				.forEach(img -> {
					Future<?> imgFuture = executor.submit(() -> {
						HttpRequest imgRequest = HttpRequest.newBuilder()
							.uri(URI.create("https://http2.akamai.com"+img))
							.build();
						
						try {
							HttpResponse<String> imgResponse = client.send(imgRequest, HttpResponse.BodyHandlers.ofString());
							System.out.println("Img loaded:" +img + " status: " + imgResponse.statusCode());
						} catch (IOException | InterruptedException e) {
							System.out.println("erro na requisição para recuperar a imagem ' "+img+"'");
							e.printStackTrace();
						}
					});
					
					future.add(imgFuture);
					System.out.println("Future submitted to image: "+ img);
				});
			
			future.forEach(f -> {
				try {
					f.get();
				} catch (InterruptedException | ExecutionException e) {
					System.out.println("Error ao esperar a image carregar do Future");
					//e.printStackTrace();
				}
			});
			
			
			long end = System.currentTimeMillis();
			System.out.println("Tempo total HTTP/2: "+ (end-start) + "ms");
			
		//} catch (IOException e) {
		//	e.printStackTrace();
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		}finally {
			executor.shutdown();
		}
	}
	
	
	private static void getHttp(String uri) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.GET().uri(URI.create(uri)).build();
		
		HttpClient httpClient = HttpClient.newHttpClient();
		var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(response.statusCode());
		System.out.println(response.headers());
		System.out.println(response.toString());
		System.out.println(response.body());
	}
	
	
	public static void main(String[] args) throws Exception, InterruptedException {
		//var uri = "https://portal.ifrn.edu.br/";
		//getHttp(uri);
		
		connecAkanaiServertHttp11();
		//connecAkanaiServertHttp2();
	}
	


}
