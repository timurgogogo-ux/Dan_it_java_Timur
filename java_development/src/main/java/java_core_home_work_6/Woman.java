package java_core_home_work_6;

    public final class Woman extends Human {

        public Woman(String name, String surname, int year) {
            super(name, surname, year);
        }

        public Woman(String name, String surname, int year, int iq, String[][] schedule, Family family) {
            super(name, surname, year, iq, schedule, family);
        }

        @Override
        public void greetPet() {
            if (getFamily() != null && getFamily().getPet() != null) {
                System.out.println("Hello, my sweet " + getFamily().getPet().getNickname() + "!");
            } else {
                System.out.println("I wish I had a pet...");
            }
        }

        public void makeup() {
            System.out.println("Applying makeup and getting ready for the day.");
        }
    }