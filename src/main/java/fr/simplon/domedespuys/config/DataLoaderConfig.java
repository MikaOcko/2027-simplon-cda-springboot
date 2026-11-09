package fr.simplon.domedespuys.config;

import com.github.javafaker.Faker;
import fr.simplon.domedespuys.entity.*;
import fr.simplon.domedespuys.repository.*;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

@Component
@AllArgsConstructor
public class DataLoaderConfig implements CommandLineRunner {

    private UserRepository userRepository;
    private BrandRepository brandRepository;
    private AddressRepository addressRepository;
    private ProductRepository productRepository;
    private ImageRepository imageRepository;
    private OrderRepository orderRepository;
    private OrderProductRepository orderProductRepository;

    @Transactional
    @Override
    public void run(String @NonNull ... args) {
        createUsers();
        createBrands();
        createAddresses();
        createProducts();
        createImages();
        createOrders();
        createOrderProducts();
    }

    private void createUsers() {
        if (0 == userRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 20; i++) {
                User user = new User();
                user.setFirstname(faker.name().firstName());
                user.setLastname(faker.name().lastName());
                String email = faker.internet().emailAddress((user.getFirstname() + "." + user.getLastname()).toLowerCase());
                user.setEmail(email);
                user.setPassword(faker.internet().password(12, 20));
                if (hasProbability(2, 3)) {
                    user.setPhone(faker.phoneNumber().phoneNumber());
                }
                LocalDateTime localDate = new java.sql.Date(faker.date().birthday(0, 5).getTime()).toLocalDate().atTime(0, 0);
                user.setCreatedAt(localDate);
                userRepository.save(user);
            }

            userRepository.flush();
        }
    }

    private void createBrands(){
        if (0 == brandRepository.count()){
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 5; i++) {
                Brand brand = new Brand();

                String label = faker.company().name();
                brand.setLabel(
                        label.length() > 20 ? label.substring(0,20) : label
                );

                String logo = faker.company().logo();
                brand.setLogo(
                        logo.length() > 20 ? logo.substring(0,20) : logo
                );

                String slug = faker.internet().slug();
                brand.setSlug(
                        slug.length() > 20 ? slug.substring(0,20) : slug
                );

                brandRepository.save(brand);
            }

            brandRepository.flush();
        }
    }

    private void createAddresses() {
        if (0 == addressRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            List<User> users = userRepository.findAll();
            Random random = new Random();

            if (users.isEmpty()){
                throw new IllegalStateException("Aucun utilisateur disponible");
            }

            for (int i = 0; i < 50; i++) {
                Address address = new Address();

                address.setCity(faker.address().city());
                address.setCountry("France");
                address.setLine(faker.address().streetAddress());
                address.setZipCode(faker.address().zipCode());

                if (hasProbability(1, 4)) {
                    address.setExtraLine(faker.address().buildingNumber());
                }

                //Sélection aléatoire d'un user existant
                User user = users.get(random.nextInt(users.size()));
                address.setUser(user);

                /*
                Random random = new Random();
                long userId = random.nextLong(1, 100);

                Optional<User> optionalUser = userRepository.findById(userId);
                optionalUser.ifPresent(address::setUser);
                */

                //Si l'objet attendu via notre 'Optional' est présent (isPresent)
                //alors on apelle la fonction 'setUser' depuis l'objet 'address' avec l'objet présent dans l'optional
                /*
                    if (optionalUser.isPresent()){
                        User user = optionalUser.get();
                        address.setUser(user);
                    }
                */
                /*
                User user = optionalUser.orElseThrow();
                address.setUser(user);
                */
                if (hasProbability(1, 4)) {
                    address.setFirstname(address.getUser().getFirstname());
                    address.setLastname(address.getUser().getLastname());
                    address.setPhone(address.getUser().getPhone());

                } else {
                    address.setFirstname(faker.name().firstName());
                    address.setLastname(faker.name().lastName());
                    address.setPhone(faker.phoneNumber().phoneNumber());
                }

                address.setCreatedAt(getRandomDate(faker, 0, 4));

                addressRepository.save(address);
            }

            addressRepository.flush();
        }
    }

    private void createProducts(){
        if (0 == productRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 50; i++) {
                Product product = new Product();

                String label = faker.beer().name();
                product.setLabel(
                        label.length() > 20 ? label.substring(0,20) : label
                );

                product.setPrice(faker.number().numberBetween(300, 1500));
                product.setCreatedAt(getRandomDate(faker, 0, 4));

                String slug = faker.internet().slug();
                product.setSlug(
                        slug.length() > 20 ? slug.substring(0,20) : slug
                );

                product.setDescription("Style : " + faker.beer().style() + "\n Ingredients : " + faker.food().ingredient());

                Optional<Brand> optionalBrand = brandRepository.findById((long) faker.number().numberBetween(1, 50));
                optionalBrand.ifPresent(product::setBrand);

                productRepository.save(product);
            }

            productRepository.flush();
        }
    }

    private void createImages(){
        if (0 == imageRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 25; i++) {
                Image image = new Image();

                image.setPath("https://picsum.photos/400/300?r=" + faker.number().randomNumber());
                image.setExtension(".jpg");
                image.setIsDefault(faker.bool().bool());

                Optional<Product> optionalProduct = productRepository.findById((long) faker.number().numberBetween(1, 50));
                optionalProduct.ifPresent(image::setProduct);

                imageRepository.save(image);
            }

            imageRepository.flush();
        }
    }

    private void createOrders(){
        if (0 == orderRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            List<User> users = userRepository.findAll();
            List<Address> addresses = addressRepository.findAll();
            Random random = new Random();

            for (int i = 0; i < 5; i++) {
                Order purchase = new Order();

                purchase.setNumber("ORD-" + LocalDateTime.now().getYear() + "-" + faker.number().numberBetween(0, 999999));
                purchase.setCreatedAt(getRandomDate(faker, 0, 4));


                User user = users.get(random.nextInt(users.size()));
                purchase.setUser(user);

                Address address = addresses.get(random.nextInt(users.size()));
                purchase.setAddress(address);

                orderRepository.save(purchase);
            }

            orderRepository.flush();
        }
    }

    private void createOrderProducts(){
        if (0 == orderProductRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            List<Order> purchases = orderRepository.findAll();
            Random random = new Random();

            for (int i = 0; i < 5; i++) {
                OrderProduct purchaseProduct = new OrderProduct();

                purchaseProduct.setQuantity(faker.number().numberBetween(1, 100));
                purchaseProduct.setPrice(faker.number().numberBetween(10,999));

                Order purchase = purchases.get(random.nextInt(purchases.size()));
                purchaseProduct.setPurchase(purchase);

                orderProductRepository.save(purchaseProduct);
            }

            orderProductRepository.flush();
        }
    }

    private LocalDateTime getRandomDate(Faker faker, int min, int max) {
        return new java.sql.Date(faker.date().birthday(min, max).getTime()).toLocalDate().atTime(0,0);
    }

    private boolean hasProbability(int expected, int max) {
        Random random = new Random();
        // random.nextInt(max) = génère un entier aléatoire entre 0 et MAX
        // expected = la proba attendue
        // Si le random est inférieure ou égale à la prob, alors on renvoie true
        return random.nextInt(max) < expected;
    }


}