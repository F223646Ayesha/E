package dal;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class AbstractDAOFactory implements IDAOFactory {
    private static IDAOFactory instance = null;

    public static IDAOFactory getInstance() {
        if (instance == null) {
        	instance = new MySQLDAOFactory();
        }
            
        return instance;
    }
}

/*String factoryClassName = null;
try (FileInputStream input = new FileInputStream("config.properties")) {
Properties prop = new Properties();
prop.load(input);
factoryClassName = prop.getProperty("dal.factory");

Class<?> clazz = Class.forName(factoryClassName); // Load class by name
instance = (IDAOFactory) clazz.getDeclaredConstructor().newInstance(); // Instantiate class
} catch (IOException e) {
e.printStackTrace();
} catch (Exception e) {
e.printStackTrace();
}
}*/