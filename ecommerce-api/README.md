# ecommerce-api
Ecommerce API Service is Backend Application Build on SpringBoot
=====================================================================> 

1: The Application has Products details with ProductCategory.
   And at first phase only has Get Products details API produces 
   which will be consumed from ecommerce-ui.

2: The Application using database for saving products details. 

3: The Application Uses Pre-Defined SQL Script to Insert initial Data.

   
====================== Circular Dependency Issue =====================> 

Faced Circular Dependency Issue with Hibernate @ManyToOne/@OneToMany Relation.

This is Resolved with below Information:

 https://stackoverflow.com/questions/18672701/jackson-circular-dependencies-cant-resolve-or-find-correct-solution.
 
================ Sample Code To Resolve Circular Dependency ============> 

IN : public class ProductCategory :

 @JsonManagedReference("product-category")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;
	
IN : public class Product :	

 @JsonBackReference("product-category")
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

============================= * END *  ==============================> 