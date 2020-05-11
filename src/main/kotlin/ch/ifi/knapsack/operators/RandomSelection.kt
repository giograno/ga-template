package ch.ifi.knapsack.operators

import ch.ifi.knapsack.Chromosome
import java.util.*

class RandomSelection: Selection {

    override fun selectParents(population: List<Chromosome>): Pair<Chromosome, Chromosome> {
        Collections.shuffle(population)
        return Pair(population[0], population[1])
    }

}