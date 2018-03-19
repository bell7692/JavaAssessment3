package parsing_json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.oracle.tools.packager.IOUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

public class ElementCollection extends ArrayList<Element> {

    private ElementCollectionInitializer elementCollectionInitializer;
    private Element element;
    private ArrayList<Element> elementArrayList;

    {
        try {
            elementArrayList = ElementCollectionInitializer.generate();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ElementCollection() {

    }

    public void addElements(Element e) {
        elementArrayList.add(e);
    }


//findByAtomicNumber will take an argument int atomicNumber and
// return the Element with number atomicNumber

    public Element findByAtomicNumber(int atomic_number) {
        for (Element element : elementArrayList) {
            if (element.getNumber() == atomic_number) {
                return element;
            }
        }
        return null;

    }

    //findByName will take an argument String name and
// return the Element with name name
    public Element findByName(String name) {
        for (Element element : elementArrayList) {
            if (element.getName().equalsIgnoreCase(name)) {
                return element;
            }
        }
        return null;
    }

    public ElementCollection where(String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Class aclass = Element.class;
        Field field = aclass.getField(fieldName);
        ElementCollection elementCollection = new ElementCollection();
        for (Element el : elementArrayList) {
            elementCollection.addElements(el);
        }
        for (Element el : elementCollection) {
            if (field.get(el).equals(value)) {
                return elementCollection;
            }
            elementCollection.clear();

        }
        return elementCollection;

    }

}
