package menu;

import dao.UserDaoImpl;
import models.TrainingApparatus;
import models.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import serviceUser.ServiceUser;
import utils.HibernateSessionFactoryUtil;

import javax.transaction.Transactional;
import java.util.List;

public class DaoMenu extends UserDaoImpl {

    ServiceUser serviceUser = new ServiceUser();
    Users usersOne = null;
    TrainingApparatus trainingApparatus = null;
    private boolean flag = true;


    public void startMenuDao() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        System.out.println("Welcome to DAO menu.\n");
        SelectAction.menu();
        while (flag) {
            switch (ScannerText.getInt()) {
                case 1:
                    Transaction tx = session.beginTransaction();
                    System.out.println("Will enter your data.");
                    System.out.print("Firstname: ");
                    String firstname = ScannerText.getString();
                    System.out.print("Lastname: ");
                    String lastname = ScannerText.getString();
                    System.out.print("Age: ");
                    int age = ScannerText.getInt();
                    usersOne = new Users(firstname, lastname, age);

                    System.out.println("\nЕnter the characteristics of the simulator you are looking for. ");
                    System.out.print("Model: ");
                    String model = ScannerText.getString();
                    System.out.print("Color: ");
                    String color = ScannerText.getString();
                    System.out.print("Price: ");
                    int price = ScannerText.getInt();
                    trainingApparatus = new TrainingApparatus(model, color, price);
                    usersOne.addTrainingApparatuses(trainingApparatus);
                    session.save(usersOne);
                    tx.commit();
                    System.out.println("The user was added successfully. \n");
                    SelectAction.menu();
                    break;
                case 2:
                    Transaction tx2 = session.beginTransaction();
                    System.out.print("Enter ID user which do you want update: ");
                    usersOne = serviceUser.findByUser(ScannerText.getInt());
                    System.out.println("Will enter your data.");
                    System.out.print("Firstname: ");
                    usersOne.setFirst_name(ScannerText.getString());
                    System.out.print("Lastname: ");
                    usersOne.setLast_name(ScannerText.getString());
                    System.out.print("Age: ");
                    usersOne.setAge(ScannerText.getInt());

                    session.merge(usersOne);
                    tx2.commit();
                    System.out.println("The user was updated successfully. \n");
                    SelectAction.menu();
                    break;
                case 3:
                    Transaction tx3 = session.beginTransaction();
                    System.out.print("Enter ID user which do you want delete: ");
                    Query query = session.createQuery("DELETE FROM Users WHERE id = :usersId");
                    query.setParameter("usersId", ScannerText.getInt());
                    query.executeUpdate();
                    tx3.commit();
                    System.out.println("The user was delete successfully. \n");
                    SelectAction.menu();
                    break;
                case 4:
                    Transaction tx4 = session.beginTransaction();
                    System.out.print("Enter ID user which do you want look: ");
                    usersOne = serviceUser.findByUser(ScannerText.getInt());
                    System.out.println(usersOne);
                    tx4.commit();
                    SelectAction.menu();
                    break;
                case 5:
                    Transaction tx5 = session.beginTransaction();
                    List<Users> users = (List<Users>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Users").list();
                    System.out.println(users);
                    tx5.commit();
                    SelectAction.menu();
                    break;
                case 6:
                    session.close();
                    System.out.println("Good bye!");
                    flag = false;
                    break;
            }
        }
    }
}
