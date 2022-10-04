package sources;

import java.util.List;
import java.util.stream.Collectors;

class Java {
    // tag::streams[]
    List<String> filteredStrings = List.of("cola", "coffee", "champagne").stream()
            .filter(str -> str.startsWith("c"))
            .collect(Collectors.toList());
    // end::streams[]

    // tag::lazyCollection[]
    Integer firstOddNumber = List.of(1, 2, 3, 4, 5).stream()
            .filter(n -> n % 2 == 0)
            .findFirst() // will only cycle through the first one
            .get();
    // end::lazyCollection[]
}
