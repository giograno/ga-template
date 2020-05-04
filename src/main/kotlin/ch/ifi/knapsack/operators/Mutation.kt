package ch.ifi.knapsack.operators

import ch.ifi.knapsack.Chromosome
import ch.ifi.knapsack.Gene
import java.util.*

class Mutation(var objects: List<Gene>) {

    fun mutate(pair: Pair<Chromosome, Chromosome>): Pair<Chromosome, Chromosome> {
        var ch1 : Chromosome = addObject(pair.first)
        var ch2 : Chromosome = addObject(pair.second)
        return Pair(ch1, ch2)
    }

    private fun addObject(chromosome: Chromosome): Chromosome {
        Collections.shuffle(objects)
        chromosome.addGene(objects[0])
        return chromosome
    }
}