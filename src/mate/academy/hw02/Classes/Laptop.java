package mate.academy.hw02.Classes;

// Nested Inner Class
public class Laptop {
    private String producer;
    private String model;
    private Processor processor;

    public Laptop(String producer, String model, Processor processor) {
        this.producer = producer;
        this.model = model;
        this.processor = processor;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", processor=" + processor +
                '}';
    }

    public static class Processor {

        private String name;
        private int cores;
        private int threads;

        public Processor(String name, int cores, int threads) {
            this.name = name;
            this.cores = cores;
            this.threads = threads;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCores() {
            return cores;
        }

        public void setCores(int cores) {
            this.cores = cores;
        }

        public int getThreads() {
            return threads;
        }

        public void setThreads(int threads) {
            this.threads = threads;
        }

        @Override
        public String toString() {
            return "{" + name + '\'' +
                    ", cores=" + cores +
                    ", threads=" + threads +
                    '}';
        }
    }

    public static void main(String[] args) {
        Laptop.Processor processor = new Laptop.Processor("I7-8700", 6, 18);
        Laptop myLaptop = new Laptop("Asus", "ROG", processor);

        Laptop laptop = new Laptop("Asus", "K53", new Processor("I9-9900K", 8, 32));
        System.out.println(laptop);
    }
}
