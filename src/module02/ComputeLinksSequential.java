package module02;

import java.util.HashSet;
import java.util.Set;

public class ComputeLinksSequential implements ComputeLinks {
  private Set<String> visited = new HashSet<>();
  
  private void visitSubLinks(String url) {
    visited.add(url);
    
    LinksFinder.getLinks(url)
               .stream()
               .filter(link -> !visited.contains(link))
               .forEach(this::visitSubLinks);
  }
  
  public long countLinks(String url) {
    visitSubLinks(url);
      System.out.println("Set: " + visited);
    return visited.size();
  }
}
