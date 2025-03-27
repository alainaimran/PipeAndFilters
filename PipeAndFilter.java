/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeandfilter;

/**
 *
 * @author sp23-bse-069
 */

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

public class PipeAndFilter {

    public static void main(String[] args) {


List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        // Create a pipeline
        List<Function<List<Integer>, List<Integer>>> filters = new ArrayList<>();
        filters.add(PipeAndFilter::filterEvenNumbers);
        filters.add(PipeAndFilter::squareNumbers);
        filters.add(PipeAndFilter::filterNumbersGreaterThanTen);
        filters.add(PipeAndFilter::filterOddNumbers);
        filters.add(PipeAndFilter::filterCubeNumbers);

        // Process the input through the pipeline
        List<Integer> result = processPipeline(input, filters);

        // Output the result
        System.out.println(result);
    }

    // Process the input through the pipeline of filters
    private static List<Integer> processPipeline(List<Integer> input, List<Function<List<Integer>, List<Integer>>> filters) {
        List<Integer> output = input;
        for (Function<List<Integer>, List<Integer>> filter : filters) {
            output = filter.apply(output);
        }
        return output;
    }

    // Filter to keep even numbers
    private static List<Integer> filterEvenNumbers(List<Integer> input) {
        return input.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    // Filter to square the numbers
    private static List<Integer> squareNumbers(List<Integer> input) {
        return input.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // Filter to keep numbers greater than 10
    private static List<Integer> filterNumbersGreaterThanTen(List<Integer> input) {
        return input.stream()
                .filter(n -> n > 10)
                .collect(Collectors.toList());
    }
    
     // Filter to keep odd numbers
    private static List<Integer> filterOddNumbers(List<Integer> input) {
        return input.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
    }
    
     // Filter to keep even numbers
    private static List<Integer> filterCubeNumbers(List<Integer> input) {
        return input.stream()
                .filter(n -> n*n*n == 0)
                .collect(Collectors.toList());
    }


}