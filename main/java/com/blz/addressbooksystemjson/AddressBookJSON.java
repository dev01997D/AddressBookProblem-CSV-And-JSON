package com.blz.addressbooksystemjson;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.blz.addressbooksystemcsv.controller.Contact;
import com.google.gson.Gson;

public class AddressBookJSON {
	private static final String JSON_FILE_PATH = "E:\\Eclipse-Workspace-java-developer\\addressbooksystemcsv"
			+ "\\src\\main\\java\\com\\blz\\addressbooksystemjson\\ContactList.json";

	public static void main(String[] args) throws Exception {
		AddressBookJSON addressBookJSON = new AddressBookJSON();
		addressBookJSON.writeDataIntoJsonFile();
		addressBookJSON.readDataFromJsonFile();
	}

	// reading data from the JSon file using GSON
	private void readDataFromJsonFile()  {
		List<Contact> contactsList = new ArrayList<Contact>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(JSON_FILE_PATH));
			System.out.println(contactsList.addAll(Arrays.asList(new Gson().fromJson(reader, Contact[].class))));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// writing data into JSON file using GSON
	private void writeDataIntoJsonFile() throws IOException {
		Writer writer = Files.newBufferedWriter(Paths.get(JSON_FILE_PATH));
		List<Contact> contactList = new ArrayList<>();
		contactList.add(new Contact("Devnandan", "Kumar", "Basariya", "Hazaribagh", "Jharkhand", 825323l, 7870752948l,
				"Dev@gmail.com"));
		contactList.add(new Contact("Manoj", "Kumar", "Simdega", "Hazaribagh", "Jharkhand", 825323l, 78708974565l,
				"Manoj@gmail.com"));
		Gson gson=new Gson();
		gson.toJson(contactList, writer);
		writer.close();
	}

}
