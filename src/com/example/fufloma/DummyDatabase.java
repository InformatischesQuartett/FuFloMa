package com.example.fufloma;

import java.util.ArrayList;



public class DummyDatabase {
	
	private ArrayList<ProductListItem> dbcontent = new ArrayList<ProductListItem>();
	
	public DummyDatabase() {
		
		//ArrayList<ProductListItem> results = new ArrayList<ProductListItem>();
		ProductListItem productData = new ProductListItem();
		productData.setId(0);
		productData.setDescription("Gaaaaannnnnz toller kram und Zeugs hier, und natürlich auch vieles mehr und so.");
		productData.setLocation("Gerwigstraße 1, 78120 Furtwangen im Schwarzwald");
		productData.setPrice(1.30f);
		productData.setState(StateEnum.ALMNEW);
		dbcontent.add(productData);
		
		productData = new ProductListItem();
		productData.setId(1);
		productData.setDescription("PlaySystem 5 wie neu!");
		productData.setLocation("Baumannstraße 15, 78120 Furtwangen im Schwarzwald");
		productData.setPrice(10.77f);
		dbcontent.add(productData);

		productData = new ProductListItem();
		productData.setId(2);
		productData.setDescription("Comodore C4096, bester ever");
		productData.setLocation("Rabenstraße 31, 78120 Furtwangen im Schwarzwald");
		productData.setPrice(666.77f);
		dbcontent.add(productData);

		productData = new ProductListItem();
		productData.setId(3);
		productData.setDescription("Bla");
		productData.setLocation("Allmendweg 2, 78147 Vöhrenbach");
		productData.setPrice(667.77f);
		dbcontent.add(productData);

		productData = new ProductListItem();
		productData.setId(4);
		productData.setDescription("Schrottwagen");
		productData.setLocation("Roßbergstraße 5, St. Georgen");
		productData.setPrice(392.74f);
		dbcontent.add(productData);
}
	
	public ArrayList<ProductListItem> getListData(String searchLocation, boolean checkBool) {
		ArrayList<ProductListItem> results = new ArrayList<ProductListItem>();
		
		for (ProductListItem item: dbcontent)
		{
			if (item.getLocation().contains(searchLocation) == checkBool)
				results.add(item);
		}
		
		return results;
	}

	public ProductListItem getItem(int id) {
		return dbcontent.get(id);
	}
}
