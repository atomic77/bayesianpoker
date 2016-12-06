package ch.usi.tomica.poker;
import edu.ucla.belief.*;
import edu.ucla.belief.io.PropertySuperintendent;
import edu.ucla.belief.io.NetworkIO;
import edu.ucla.belief.inference.RCEngineGenerator;
import edu.ucla.belief.inference.RCInfo;
import edu.ucla.belief.inference.RCSettings;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
  @author Alex Tomic
  @since Aug 23, 2012 2:46:54 PM
*/
public class ProbabilityQuery
{

  public void doProbabilityQuery( BeliefNetwork bn )
  {
    /* Define evidence, by id. */
    Map<FiniteVariable, Object> evidence = new HashMap<FiniteVariable, Object>(2);
    FiniteVariable var = null;
    var = (FiniteVariable) bn.forID( "Board3" );
    evidence.put( var, var.instance( "rainbow" ) );
    var = (FiniteVariable) bn.forID( "OppBet3" );
    evidence.put( var, var.instance( "small" ) );

    /* Create the Dynamator(edu.ucla.belief.inference.SynchronizedInferenceEngine$SynchronizedPartialDerivativeEngine). */
    RCEngineGenerator dynamator = new RCEngineGenerator();

    configureBeliefNetwork(bn);

    /* Create the InferenceEngine. */
    InferenceEngine engine = dynamator.manufactureInferenceEngine( bn );

    /* Set evidence. */
    try{
      bn.getEvidenceController().setObservations( evidence );
    }catch( StateNotFoundException e ){
      System.err.println( "Error, failed to set evidence: " + e );
      return;
    };

    /* Calculate Pr(e). */
    double pE = engine.probability();
    System.out.println( "Pr(e): " + pE );
    System.out.println();

    /* Define the set of 11 variables for which we want marginal probabilities, by id. */
    Set<Variable> marginalVariables = new HashSet<Variable>();
	String[] arrayMarginalVariableIDs = new String[] { "Board4",
				"OppHand5", "OppBet3", "OppHand4", "Board3", "OppBet5",
				"Board5", "OppBetBlind", "OppBet4", "OppDealtCards", "OppHand3" };
	
    for( int i=0; i<arrayMarginalVariableIDs.length; i++ ){
      marginalVariables.add( bn.forID( arrayMarginalVariableIDs[i] ) );
    }

    /* Calculate marginals. */
    System.out.println( "Marginal probability tables:" );
    for (Variable varMarginal : marginalVariables) {
      Table answer = engine.conditional((FiniteVariable)varMarginal);
      System.out.println( answer.tableString() );
      System.out.println();
    }

    /* Clean up to avoid memory leaks. */
    engine.die();
    return;
  }

private void configureBeliefNetwork(BeliefNetwork bn) {
	/* Edit settings. */
    RCSettings settings = RCEngineGenerator.getSettings( (PropertySuperintendent)bn );
    /*
      Define the elimination heuristic used to create the dtree, one of:
        MIN_FILL (Min Fill), MIN_SIZE (Min Size)
    */
    settings.setEliminationHeuristic( EliminationHeuristic.MIN_FILL );
    /* Do not create an InferenceEngine optimized for only Pr(e). */
    settings.setPrEOnly(              false );
    /* Set the fraction of full memory to use. */
    settings.setUserMemoryProportion( 1.0 );
    /* Create the cache allocation (very important). */
    try{
      settings.validateAllocation( bn );
    }catch( Throwable throwable ){
       System.err.println( "Error, failed to validate cache allocation: " + throwable );
       System.exit(-1);
    }

    /* Characterize the cache allocation and estimated run time. */
/*    double     actualProportion          = settings.getActualMemoryProportion();
    RCInfo     info                      = settings.getInfo();
    BigInteger cacheEntriesFullCaching   = info.cacheEntriesFullCaching();
    BigInteger allocatedCacheEntries     = info.allocatedCacheEntries();
    double     recursiveCallsFullCaching = info.recursiveCallsFullCaching();
    double     recursiveCalls            = info.recursiveCalls();*/
}

  /**
    Open the network file used to create this tutorial.
  */
  public BeliefNetwork readNetworkFile()
  {
    String path = "/home/atomic/Documents/USI/S3/Uncertain/A1/A1-final.net";

    BeliefNetwork ret = null;
    try{
      /* Use NetworkIO static method to read network file. */
      ret = NetworkIO.read( path );
    }catch( Exception e ){
      System.err.println( "Error, failed to read \"" + path + "\": " + e );
      return null;
    }
    return ret;
  }
  
  public static void main(String[] args){
    ProbabilityQuery T = new ProbabilityQuery();
    T.doProbabilityQuery( T.readNetworkFile() );
  }
  
}
