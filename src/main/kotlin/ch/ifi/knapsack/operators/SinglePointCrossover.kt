package ch.ifi.knapsack.operators

import ch.ifi.knapsack.Chromosome
import ch.ifi.knapsack.Gene

class SinglePointCrossover: Crossover{

    companion object {
        fun crossover(parents: Pair<Chromosome, Chromosome>): Pair<Chromosome, Chromosome> {
            // random split points
            val firstSplitPoint: Int = (0 until parents.first.getSize()).random()
            val secondSplitPoint: Int = (0 until parents.second.getSize()).random()
            var firstSlice: MutableList<Gene> = parents.first.getSlice(0, firstSplitPoint)
            var secondSlice: List<Gene> = parents.second.getSlice(secondSplitPoint, parents.second.getSize())

            // checks for empty lists
            if (firstSlice.isEmpty())
                firstSlice = parents.first.genes.toMutableList()
            if (secondSlice.isEmpty())
                secondSlice = parents.second.genes.toMutableList()

            // create the offsprings
            val offspringOne = Chromosome(parents.first.maxWeight)
            offspringOne.addGenes(firstSlice + secondSlice)
            val offspringTwo = Chromosome(parents.second.maxWeight)
            offspringTwo.addGenes(secondSlice + firstSlice)
            return Pair(offspringOne, offspringTwo)
        }
    }
}