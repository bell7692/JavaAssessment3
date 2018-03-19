package parsing_json;

import java.util.ArrayList;
import java.util.Collection;

public class ElementCollection extends ArrayList<Element> {

    private Element element;

    private ArrayList<Element> elementArrayList;

    public ElementCollection() {
        elementArrayList = new ArrayList<>();
    }

    public void addElements(Element e){
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
        return element;

    }
//findByName will take an argument String name and
// return the Element with name name
    public Element findByName(String name) {
        for(Element element: elementArrayList){
            if(element.getName().equalsIgnoreCase(name)){
                return element;
            }
        }
        return null;
    }

    public ElementCollection where(String fieldName, Object value) {
        ElementCollection elementCollection = new ElementCollection();
        for (Element el : elementArrayList){
            if(elementArrayList.contains(el)){
                elementCollection.add(el);
            }
        }
        return elementCollection;
    }
}
