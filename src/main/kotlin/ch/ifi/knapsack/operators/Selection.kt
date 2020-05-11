package ch.ifi.knapsack.operators

import ch.ifi.knapsack.Chromosome

interface Selection {
    fun selectParents(population: List<Chromosome>): Pair<Chromosome, Chromosome>
}