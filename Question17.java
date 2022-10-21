// Switch Expressions

public enum Position {

    GOALKEEPER,

    DEFENCE,

    MIDFIELDER,

    STRIKER,

    BENCH

}

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class SwitchExpression {

    private Map<Integer, Position> positionMap = new HashMap<>();

    private int                    randomNumber;

    private Position               randomPosition;

    @BeforeEach

    public void setup() {

        positionMap.put(1, GOALKEEPER);

        positionMap.put(2, DEFENCE);

        positionMap.put(3, MIDFIELDER);

        positionMap.put(4, STRIKER);

        randomNumber = ThreadLocalRandom.current().nextInt(1, 6);

        randomPosition = Optional.ofNullable(positionMap.get(randomNumber)).orElse(BENCH);

    }

    @AfterEach

    public void tearDown() {

        positionMap.clear();

    }

    @RepeatedTest(5)

    @Order(1)

    public void oldSwitchExpressionTest() {

        switch (randomPosition) {

            case GOALKEEPER:

                System.out.println("Goal Keeper: Buffon");

                break;

            case DEFENCE:

                System.out.println("Defence: Ramos");

                break;

            case MIDFIELDER:

                System.out.println("Midfielder: Messi");

                break;

            case STRIKER:

                System.out.println("Striker: Zlatan");

                break;

            default:

                System.out.println("Please select a footballer from the BENCH!");

        }

    }

}
