import ch.ifi.knapsack.Chromosome
import ch.ifi.knapsack.Gene
import ch.ifi.knapsack.GeneticAlgorithm

fun main() {

    var items = mutableListOf<Gene>()
    items.add(Gene("lamp", 2.0, 4.2))
    items.add(Gene("wallet", 0.2, 100.3))
    items.add(Gene("iphone", 0.3, 1035.0))
    items.add(Gene("tend", 1.4, 40.0))
    items.add(Gene("tshirt", 0.3, 25.30))
    items.add(Gene("jeans", 1.2, 40.75))
    items.add(Gene("pan", 1.2, 20.5))
    items.add(Gene("laptop", 1.8, 1500.0))
    items.add(Gene("camera", 0.4, 800.0))
    items.add((Gene("water", 2.0, 7.0)))
    items.add((Gene("food", 0.5, 10.0)))
    items.add((Gene("coke", 1.5, 8.0)))
    items.add((Gene("beer", 0.9, 21.0)))
    items.add((Gene("ebook", 0.8, 300.0)))
    items.add((Gene("ipad", 1.4, 200.0)))
    items.add((Gene("hammer", 2.3, 20.0)))
    items.add((Gene("book", 0.5, 30.0)))

    val ga = GeneticAlgorithm(items = items, populationSize = 10, budget = 50, maxWeight = 5.0)
    val best: Chromosome = ga.evolve()
    print(best)
}