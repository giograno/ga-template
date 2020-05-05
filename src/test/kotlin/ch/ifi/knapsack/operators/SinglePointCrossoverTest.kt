package ch.ifi.knapsack.operators

import ch.ifi.knapsack.Chromosome
import ch.ifi.knapsack.Gene
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SinglePointCrossoverTest {

    private lateinit var chromosomeOne: Chromosome
    private lateinit var chromosomeTwo: Chromosome

    @BeforeEach
    fun setupChromosomes() {
        chromosomeOne = Chromosome(5.0)
        chromosomeOne.addGene(Gene("lamp", 2.0, 4.2))
        chromosomeOne.addGene(Gene("wallet", 0.2, 100.3))
        chromosomeOne.addGene(Gene("iphone", 0.3, 1035.0))
        chromosomeOne.addGene(Gene("tend", 1.4, 40.0))
        chromosomeOne.addGene(Gene("tshirt", 0.3, 25.30))
        print("** Parents **")
        println(chromosomeOne)

        chromosomeTwo = Chromosome(5.0)
        chromosomeTwo.addGene(Gene("jeans", 1.2, 40.75))
        chromosomeTwo.addGene(Gene("laptop", 1.8, 1500.0))
        chromosomeTwo.addGene(Gene("camera", 0.4, 800.0))
        chromosomeTwo.addGene(Gene("food", 0.5, 10.0))
        println(chromosomeTwo)
    }

    @Test
    fun testCrossover() {
        val offsprings: Pair<Chromosome, Chromosome> = SinglePointCrossover.crossover(Pair(chromosomeOne, chromosomeTwo))
        println("** Generated Offsprings **")
        println(offsprings.first)
        println(offsprings.second)
    }

}