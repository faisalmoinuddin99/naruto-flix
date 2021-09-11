package com.company.narutoflix;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;


@SpringBootApplication
public class NarutoFlixApplication {

	public static void main(String[] args) throws IOException {
		ClassLoader classLoader = NarutoFlixApplication.class.getClassLoader() ;

//		Importing serviceAccountKey.json file
		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile()) ;

		FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath()) ;



//		FireBase Authorization
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://naruto-flix-default-rtdb.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);

		SpringApplication.run(NarutoFlixApplication.class, args);


	}

}
