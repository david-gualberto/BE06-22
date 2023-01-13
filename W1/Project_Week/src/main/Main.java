package main;

import java.util.Scanner;
import fileClass.Video;
import fileClass.Audio;
import fileClass.Image;
import mediaElements.MediaElements;
import mediaElements.mediaType;

public class Main {
			
		
			static int index = 0;
			static mediaType selectedType;
			
	public static void main(String[] args) {
			MediaElements[] arrayElements = new MediaElements[5];
			System.out.println("");
			System.out.println("----Lettore Multimediale----");
			System.out.println("");
			
			//Ciclo per la creazione dei 5 file;
			Scanner input = new Scanner(System.in);
			do {
				System.out.printf("Digitare da 1 a 3 in base alla tipologia di file che si vuole scegliere:%n1)Image%n2)Audio%n3)Video%n");
				int type = input.nextInt();
					switch (type) {
				
					//Nel caso in cui è un immagine
					case 1:
						selectedType = mediaType.Image;
						System.out.println("Titolo dell'Immagine:");
						String title = input.next();
						System.out.println("Imposta una luminosità con un valore da 1 a 10: ");
						int brightness = input.nextInt();
							if (Image.checkBrightness(brightness)== false) {
							System.out.println("ERRORE! Inserire un valore valido da 1 a 10");
							System.out.println("--------------------------------------------");
							break;
							} else {
							System.out.println("--------------------------------------------");
							System.out.println("Oggetto Creato");
							System.out.println("--------------------------------------------");
							arrayElements[index] = new Image(selectedType, title, brightness);
							index++;
						;} 
							break;
					//Nel caso in cui è un Audio
					case 2:
						selectedType = mediaType.Audio;
						System.out.println("Titolo dell'file:");
						String title2 = input.next();
						System.out.println("Durata dell'audio (Impostare un valore da 1 a 10):");
						int duration = input.nextInt();
							if(Audio.checkduration(duration) == false) {
								System.out.println("--------------------------------------------");
								System.out.println("ERRORE! Inserire un valore valido da 1 a 10");
								System.out.println("--------------------------------------------");
								break;
							} else {
								System.out.println("Impostare volume di partenza (Impostare un valore da 1 a 10:");
								int volume = input.nextInt();
								if (Audio.checkVolume(volume) == false) {
									System.out.println("--------------------------------------------");
									System.out.println("ERRORE! Inserire un valore valido da 1 a 10");
									System.out.println("--------------------------------------------");
									break;
								} else {
									arrayElements[index] = new Audio(selectedType, title2, duration, volume);
									System.out.println("--------------------------------------------");
									System.out.println("Oggetto Creato");
									System.out.println("--------------------------------------------");
									index++;
									break;
								}
							}
					case 3:
					//Nel caso in cui è un Video
						selectedType = mediaType.Video;
						System.out.println("Titolo dell video:");
						String title3 = input.next();
						System.out.println("Durata del video (Impostare un valore da 1 a 10):");
						int durata3 = input.nextInt();
							if(Video.checkduration(durata3) == false) {
								System.out.println("--------------------------------------------");
								System.out.println("ERRORE! Inserire un valore valido da 1 a 10");
								System.out.println("--------------------------------------------");
								break;
								} else {
								System.out.println("Impostare volume di partenza (Impostare un valore da 1 a 10:");
								int volume3 = input.nextInt();
								if (Video.checkVolume(volume3)== false) {
									System.out.println("--------------------------------------------");
									System.out.println("ERRORE! Inserire un valore valido da 1 a 10");
									System.out.println("--------------------------------------------");
									break;
								} else {
									System.out.println("Impostare una luminosità di partenza (Impostare un valore da 1 a 10:");
									int brightness3 = input.nextInt();
									if(Video.checkBrightness(brightness3)== false) {
										System.out.println("--------------------------------------------");
										System.out.println("ERRORE! Inserire un valore valido da 1 a 10");
										System.out.println("--------------------------------------------");
										break;
									} else {
										System.out.println("--------------------------------------------");
										System.out.println("Oggetto Creato");
										System.out.println("--------------------------------------------");
										arrayElements[index] = new Video(selectedType, title3, volume3, durata3, brightness3);
										index++;
										break;
									}
								}
								}
					//Selezione Errata
					default:
						System.out.println("----------------------------------------------------------------------------");
						System.out.println("ATTENZIONE! Selezionare una delle tre voci con il rispettivo indice numerico!");
						System.out.println("----------------------------------------------------------------------------");
					} 
				} 

			 while (!(index == 5)); 
			
			int startStop;
			do {
				System.out.println("--------------------------------------------");
				System.out.println("Digita da 1 a 5 per riprodurre uno dei tuoi file! (Digita 0 per interrompere la riproduzione)");
				System.out.println("--------------------------------------------");
				startStop = input.nextInt();
				int decrease = (startStop - 1);
				if (arrayElements[decrease].type.equals(mediaType.Image)) {
					arrayElements[decrease].show();
					} else {
					arrayElements[decrease].play();
						}
				
			} while (!(startStop == 0));
			input.close();
	} 
}


