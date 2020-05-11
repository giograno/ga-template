package ch.ifi.knapsack

import ch.ifi.knapsack.operators.*
import java.util.*

class GeneticAlgorithm(items: List<Gene>,
                       var populationSize: Int,
                       var budget: Int,
                       maxWeight: Double) {

    var population = mutableListOf<Chromosome>()
    var mutation: Mutation = Mutation(objects = items)
    var selection : Selection
    var crossover: Crossover

    init {
        for (i in 1..populationSize) {
            val chromosome = Chromosome(maxWeight)
            var isFull = false
            while (!isFull) {
                Collections.shuffle(items)
                isFull = chromosome.addGene(items[0])
            }
            population.add(chromosome)
        }

        selection = RandomSelection()
        crossover = SinglePointCrossover()
    }

    fun evolve(): Chromosome {

        for (i in 1..budget) {
            val averageFitness : Double = population.stream().mapToDouble(Chromosome::totalValue)
                .average().orElse(0.0)
            var log = "Iteration $i = average fitness ${averageFitness}"
            breedNextGeneration()
            population.sort() // take the bests individuals based on the fitness function
            population = population.subList(0, populationSize)
            println(log)
        }
        return population[0]
    }

    private fun breedNextGeneration() {
        for (i in 0..populationSize/2) {
            var offsprings : Pair<Chromosome, Chromosome> = getOffsprings()
            population.add(offsprings.first)
            population.add(offsprings.second)
        }
    }

    private fun getOffsprings(): Pair<Chromosome, Chromosome> {
        // select the parents
        var parents : Pair<Chromosome, Chromosome> = selection.selectParents(population = population)
        // generate the offsprings
        var offsprings : Pair<Chromosome, Chromosome> = crossover.crossover(parents = parents)
        // mutate the offsprings
        offsprings = mutation.mutate(pair = parents)
        return offsprings
    }

}