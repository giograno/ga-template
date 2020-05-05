package ch.ifi.knapsack

class Chromosome(val maxWeight: Double) : Comparable<Chromosome> {

    val genes = mutableSetOf<Gene>()
    var totalValue: Double = 0.0
    var totalWeight: Double = 0.0

    fun addGene(gene: Gene): Boolean {
        if (totalWeight + gene.weight <= maxWeight) {
            genes.add(gene)
            totalWeight += gene.weight
            totalValue += gene.value
            return false
        }
        return true
    }

    fun addGenes(genes: List<Gene>) {
        for (g in genes)
            addGene(g)
    }

    fun getSize(): Int { return genes.size }

    fun getSlice(min: Int, max: Int): MutableList<Gene> {
        return genes.toMutableList().subList(min, max)
    }

    fun removeGene() {
        val gene: Gene = genes.last()
        totalWeight -= gene.weight
        totalValue -= gene.value
        genes.remove(gene)
    }

    override fun toString(): String {
        return "Chromosome\n-Objects=${genes.joinToString(separator = "\n")}\n" +
                "-TotalValue=$totalValue" +
                "\n-TotalWeight=$totalWeight"
    }

    override fun compareTo(other: Chromosome): Int {
        return other.totalValue.compareTo(other = this.totalValue)
    }
}