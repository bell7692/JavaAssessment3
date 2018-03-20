package parsing_json;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ElementCollection extends ArrayList<Element> {

//findByAtomicNumber will take an argument int atomicNumber and
// return the Element with number atomicNumber

    public Element findByAtomicNumber(int atomic_number) {
         for(int i = 0 ; i < this.size(); i++){
            if (this.get(i).getNumber() == atomic_number) {
                return this.get(i);
            }
        }
        return null;

    }

    //findByName will take an argument String name and
// return the Element with name name
    public Element findByName(String name) {
        for(int i = 0 ; i < this.size(); i++){
            if (this.get(i).getName().toString().equalsIgnoreCase(name)) {
                return this.get(i);
            }
        }
        return null;

    }

    public ElementCollection where(String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field[] fields = Element.class.getDeclaredFields();
        for (Field field: fields) {
            if (field.getName().equals(value)) {
                return this;
            }
            this.clear();

        }
        return this;

    }

}
