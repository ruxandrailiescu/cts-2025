import java.io.*;
import java.util.*;

class Element {
    Integer field1;
    Double field2;
    String field3;

    public Element(Integer field1, Double field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
}

// ElementRepository manages CRUD operations
class ElementRepository {
    private List<Element> elements = new ArrayList<>();

    public void addElement(Element element) {
        elements.add(element);
    }

    public void updateElement(Integer field1, Element element) {
        for (int i = 0; i < elements.size(); i++) {
            if (Objects.equals(elements.get(i).field1, field1)) {
                elements.set(i, element);
                return;
            }
        }
    }

    public void removeElement(Integer field1) {
        elements.removeIf(element -> Objects.equals(element.field1, field1));
    }

    public Element readElement(Integer field1) {
        for (Element element : elements) {
            if (Objects.equals(element.field1, field1)) {
                return element;
            }
        }
        return null;
    }

    public List<Element> getElements() {
        return new ArrayList<>(elements);
    }

    public int getSize() {
        return elements.size();
    }
}

// ElementPrinter prints elements
class ElementPrinter {
    public void printElement(Element element) {
        System.out.println("Element(" + element.field1 + ", " + element.field2 + ", " + element.field3 + ")");
    }

    public void printElements(List<Element> elements) {
        for (Element element : elements) {
            printElement(element);
        }
    }
}

// ElementFileManager manages file operations
class ElementFileManager {
    public void saveToFile(String filepath, List<Element> elements) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filepath);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos)) {

            for (Element element : elements) {
                dos.writeUTF(element.field1 + "," + element.field2 + "," + element.field3 + "\n");
            }
        }
    }

    public List<Element> loadFromFile(String filepath) throws IOException {
        List<Element> elements = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filepath);
            DataInputStream dis = new DataInputStream(fis)) {

            while (true) {
                try {
                    String line = dis.readUTF();
                    String[] parts = line.split(",");

                    if (parts.length == 3) {
                        Integer field1 = Integer.parseInt(parts[0]);
                        Double field2 = Double.parseDouble(parts[1]);
                        String field3 = parts[2];
                        elements.add(new Element(field1, field2, field3));
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        }

        return elements;
    }
}

// ElementStatistics computes statistics
class ElementStatistics {
    public int countMatchesField1(List<Element> elements, Integer field1) {
        return (int) elements.stream().filter(e -> Objects.equals(e.field1, field1)).count();
    }

    public int countMatchesField2(List<Element> elements, Double field2) {
        return (int) elements.stream().filter(e -> Objects.equals(e.field2, field2)).count();
    }

    public int countMatchesField3(List<Element> elements, String field3) {
        return (int) elements.stream().filter(e -> Objects.equals(e.field3, field3)).count();
    }

    public int sumField1(List<Element> elements) {
        return elements.stream().mapToInt(e -> e.field1).sum();
    }

    public double sumField2(List<Element> elements) {
        return elements.stream().mapToDouble(e -> e.field2).sum();
    }
}

public class SRP {
    List<Element> elements;

    public SRP() {
        this.elements = new ArrayList<>();
    }
}
