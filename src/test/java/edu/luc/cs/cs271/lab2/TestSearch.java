package edu.luc.cs.cs271.lab2;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSearch {
  
  Team[] makeArrayFixture(final int size) {
    final Team[] array = new Team[size];
    for (int i = 0; i < size; i++) {
      final String s = Integer.toString(i);
      array[i] = new Team("Team " + s, "Coach " + s, i * 100 + 50);
    }
    return array;
  }

  // similar to above function makeListFixture
  List<Team> makeListFixture (final int size){
    final List<Team> list = new ArrayList<Team>();
    for (int compare = 0; compare<size; compare++ ){ //compares arraylistsize
      final String s = Integer.toString(compare); //these are following the above steps
      list.add(new Team("Team" + s, "Coach" + s, compare*100 +50)); //add function adds new team to list
    }
    return list;
  }

  @Test
  public void testFindPositionArray0() {
    final Team[] arr = makeArrayFixture(0);
    assertFalse(Search.findTeamPosition(arr, "Team 5").isPresent());
  }

  @Test
  public void testFindPositionArray10s() {
    final Team[] arr = makeArrayFixture(10);
    assertTrue(Search.findTeamPosition(arr, "Team 5").isPresent());
  }

  @Test
  public void testFindPositionArray10f() {
    final Team[] list = makeArrayFixture(10);
    assertFalse(Search.findTeamPosition(list, "Team 11").isPresent());
  }
  
  // okay testFindPositionList0, 10s, 10f
    @Test
  public void testFindPositionList0() {
    final List<Team> list = makeListFixture(0);
    assertFalse(Search.findTeamPosition(list, "Team 5").isPresent()); //similar search to array 
  }

  @Test
  public void testFindPositionList10s() {
    final List<Team> list = makeListFixture(10);
    assertTrue(Search.findTeamPosition(list, "Team 5").isPresent());
  }

  @Test
  public void testFindPositionList10f() {
    final List <Team> arr = makeListFixture(10);
    assertFalse(Search.findTeamPosition(arr, "Team 11").isPresent());
  }
  
  //okay test testFindMinFundingArray for several sizes and scenarios
   @Test
  public void testFindMinFundingArray0() {
    final Team[] arr = makeArrayFixture(0);
    assertFalse(Search.findTeamMinFunding(arr, 500).isPresent());
  }
  
   @Test
  public void testFindMinFundingArray10s() {
    final Team[] arr = makeArrayFixture(10);
    assertTrue(Search.findTeamMinFunding(arr, 550).isPresent());
  }
  
   @Test
  public void testFindMinFundingArray5f() {
    final Team[] arr = makeArrayFixture(5);
    assertFalse(Search.findTeamMinFunding(arr, 600).isPresent());
}

  // TODO: testFindMinFundingArrayFast for several sizes and scenarios
  @Test
  public void testFindMinFundingArrayFast10s(){
    final Team[] arr = makeArrayFixture(10);
    assertFalse(Search.findTeamMinFundingFast(arr, 500).isPresent());
   }
  @Test
  public void testFindMinFundingArrayFast10f() {
    final Team[] arr = makeArrayFixture(10);
    assertTrue(Search.findTeamMinFunding(arr, 650).isPresent());
  }
}
