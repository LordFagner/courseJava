package com.FagCorps.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.FagCorps.course.Repositorys.CategoryRepository;
import com.FagCorps.course.Repositorys.OrderItemRepository;
import com.FagCorps.course.Repositorys.OrderRepository;
import com.FagCorps.course.Repositorys.ProductRepository;
import com.FagCorps.course.Repositorys.UserRepository;
import com.FagCorps.course.entites.Category;
import com.FagCorps.course.entites.Order;
import com.FagCorps.course.entites.OrderItem;
import com.FagCorps.course.entites.Payment;
import com.FagCorps.course.entites.Product;
import com.FagCorps.course.entites.User;
import com.FagCorps.course.entites.Enums.OrderStatus;

@Configuration
@Profile("test") // Define que essa configuração será usada apenas no perfil 'test'
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRep;

	@Autowired
	private OrderRepository OrderRep;

	@Autowired
	private CategoryRepository CatRep;
	@Autowired
	private ProductRepository ProRep;
	@Autowired
	private OrderItemRepository ordIRep;

	@Override
	public void run(String... args) throws Exception {
		// Verifique se o repositório está sendo injetado corretamente.
		if (userRep == null) {
			System.out.println("UserRepository não foi injetado corretamente.");
			return;
		}
		if (OrderRep == null) {
			System.out.println("OrderRepository não foi injetado corretamente.");
			return;
		}

		// Criando usuários para adicionar no banco de dados de teste
		User U1 = new User(null, "crops", "fagnscasr@email.com", "9231931312", "123131231");
		User U2 = new User(null, "beatriz", "Bcosta21@email.com", "921321931312", "1242141231231");
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), U1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), U2, OrderStatus.WATTING_PEYMENT);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), U1, OrderStatus.DELIVERED);
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		p1.getCategorys().add(cat2);
		p2.getCategorys().addAll(Arrays.asList(cat1));
		p3.getCategorys().addAll(Arrays.asList(cat1, cat3));
		p4.getCategorys().addAll(Arrays.asList(cat1));
		p5.getCategorys().addAll(Arrays.asList(cat2));
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		// Salvando todos os usuários no banco de dados
		userRep.saveAll(Arrays.asList(U1, U2));

		OrderRep.saveAll(Arrays.asList(o1, o2, o3));

		CatRep.saveAll(Arrays.asList(cat1, cat2, cat3));

		ProRep.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		ordIRep.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

		Payment pay = new Payment(null,Instant.parse("2019-06-20T21:53:07Z"),o1);
		o1.setPayment(pay);
		OrderRep.save(o1);
		
		System.out.println("Usuários salvos no banco de dados de teste.");
	
	
	
	}
	
}
