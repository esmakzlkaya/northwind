package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

	Product getByProductName(String productName);
	Product getByProductNameAndCategory_Id(String productName,int categoryId);
	List<Product> getByProductNameOrCategory_Id(String productName,int categoryId);
	List<Product> getByCategory_IdIn(List<Integer> categories);
	List<Product> getByProductNameContains(String productName);
	List<Product> getByProductNameStartsWith(String productName);
	
	//veritabanı tablo adı değil entity adı yazılır, veritabanı kolon isimleri değil entity özellik isimleri
	@Query("From Product where productName=:productName and category.id=:categoryId")
	List<Product> getByNameAndCategory(String productName,int categoryId);
	//select * from products where product_name=bisey and category_id=bisey
}
