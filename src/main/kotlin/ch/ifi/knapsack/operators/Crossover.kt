package ch.ifi.knapsack.operators

import ch.ifi.knapsack.Chromosome

interface Crossover {

    fun crossover(parents: Pair<Chromosome, Chromosome>): Pair<Chromosome, Chromosome>
}