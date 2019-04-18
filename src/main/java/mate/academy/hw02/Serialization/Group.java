package mate.academy.hw02.Serialization;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Figure> figures = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Figure> getFigures() {
        return figures;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addFigure(Figure f) {
        figures.add(f);
    }

    public void addGroup(Group g) {
        groups.add(g);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", figures=" + figures +
                ", groups=" + groups +
                '}';
    }

    public static Group createGroup() {
        Group resultGroup = new Group("Group1");

        Group group = new Group("Inner group");

        Figure figure = new Triangle(3, 4, 5);
        group.addFigure(figure);

        figure = new Circle(5);
        group.addFigure(figure);

        resultGroup.addGroup(group);

        figure = new Square(4, 2);
        resultGroup.addFigure(figure);

        figure = new Circle(11);
        resultGroup.addFigure(figure);

        return resultGroup;
    }
}
