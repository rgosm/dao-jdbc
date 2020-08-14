package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== Teste 01: seller findById ===");
        Seller seller = sellerDao.findById(7);
        System.out.println(seller);

        System.out.println();
        System.out.println("=== Teste 02: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println();
        System.out.println("=== Teste 03: seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        /*System.out.println();
        System.out.println("=== Teste 04: seller Insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Id= "+ newSeller.getId());*/

        System.out.println();
        System.out.println("=== Teste 05: seller Update ===");
        seller = sellerDao.findById(15);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("Done!");

        System.out.println();
        System.out.println("=== Teste 06: seller Delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        sc.nextLine();
        sellerDao.deleteById(id);
        System.out.println("Done!");

        sc.close();
    }

}
