package function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bean.Individual;

public class GeneticAlgorithm {
	
	private int populationSize;
	private List<Individual> population = new ArrayList<>();
	private int generation;
	private Individual bestSolution;
	
	public GeneticAlgorithm(int populationSize) {
		this.populationSize = populationSize;
	}
	
	/**
	 * Method responsible for initializes the population
	 * 
	 * @param spaces list containing the spaces used by the products in the cargo
	 * @param values list containing the values of the products in the cargo
	 * @param spaceLimit cargo limit
	 */
	public void initializesPopulation(List spaces, List values, Double spaceLimit) {
		
		for(int i = 0; i < this.populationSize; i++) {
			this.population.add(new Individual(spaces, values, spaceLimit));
		}
		
		this.bestSolution = this.population.get(0);
	}
	
	/**
	 * Method responsible for analyzing the best solution between two individuals
	 * 
	 * @param anotherIndividual second individual used to perform the analysis
	 */
	public void bestIndividual(Individual anotherIndividual) {
		if(anotherIndividual.getEvaluationNote() > this.getBestSolution().getEvaluationNote()) {
			this.bestSolution = anotherIndividual;
		}
	}
	
	/**
	 * Method responsible for adding up the grades of the evaluations of a given population
	 * 
	 * @return a double containing the sum of the evaluations
	 */
	public Double evaluationSum() {
		
		Double sum = 0.0;
		
		for(Individual ind : this.population) {
			sum += ind.getEvaluationNote();
		}
		
		return sum;
	}
	
	public int selectParent(Double evaluationSum) {
		
		int parent = -1;
		Double sortValue = Math.random() * evaluationSum;
		Double sum = 0.0;
		int i = 0;
		while(i < this.population.size() && sum < sortValue) {
			sum += this.population.get(i).getEvaluationNote();
			parent += 1;
			i += 1;
		}
		return parent;
	}
	
	/**
	 * Method responsible for ordenate a given population
	 */
	public void ordenatePopulation() {
		Collections.sort(this.population);
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}

	public List<Individual> getPopulation() {
		return population;
	}

	public void setPopulation(List<Individual> population) {
		this.population = population;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public Individual getBestSolution() {
		return bestSolution;
	}

	public void setBestSolution(Individual bestSolution) {
		this.bestSolution = bestSolution;
	}
	
}
