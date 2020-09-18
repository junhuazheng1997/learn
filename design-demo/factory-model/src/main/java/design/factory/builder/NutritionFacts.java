package design.factory.builder;

/**
 * @author kris
 * @since 2020-09-18
 */
public class NutritionFacts {

    private final int servingSize; // required
    private final int servings; // required
    private final int calories; // optional
    private final int fat; // optional
    private final int sodium; // optional
    private final int carbohydrate; // optional

    public static class Builder {
        // required
        private final int servingSize;
        private final int servings;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        // optional
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Builder calories(int val) { calories = val; return this; }
        public Builder fat(int val) { fat = val; return this; }
        public Builder carbohydrate(int val) { carbohydrate = val; return this; }
        public Builder sodium(int val) { sodium = val; return this; }

        // 提供NutritionFacts构建方法以获取实例
        public NutritionFacts build() { return new NutritionFacts(this); }
    }

    // 私有化构造方法
    private NutritionFacts(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }
}
