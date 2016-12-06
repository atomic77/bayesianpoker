package ch.usi.tomica.poker.samples;
/** Import statements necessary for il2 classes. */
import il2.model.*;
import il2.model.Table;
import il2.util.*;


/**
  This class hard codes the network
  /home/atomic/Documents/USI/S3/Uncertain/A1/A1-final.net

  To compile this class, make sure
  inflib.jar occurs in the command line classpath,
  e.g. javac -classpath inflib.jar ModelTutorial.java

  To run it, do the same,
  but also include the path to
  the compiled class,
  e.g. java -classpath .:inflib.jar ModelTutorial

  @author Keith Cascio
  @since Aug 23, 2012 2:42:48 PM
*/
public class ModelTutorial
{
  /** Test. */
  public static void main( String[] args ){
    ModelTutorial T = new ModelTutorial();
    T.createBayesianNetwork();
  }

  /**
    Builds a new model from scratch, as simply as possible, using classes in package il2.model (il2).
  */
  public BayesianNetwork createBayesianNetwork()
  {
    /* Create a domain of size 11. */
    Domain domain = new Domain(11);

    /* Add a discrete variable called "Board3" to the domain,
       with states "other", "suit3", "suit4", "rainbow", "straight3", "straight4", "sf3", "triple", "pair", "twopair". */
    String     name00 = "Board3";
    String[] values00 = new String[]{ "other", "suit3", "suit4", "rainbow", "straight3", "straight4", "sf3", "triple", "pair", "twopair" };
    int          id00 = domain.addDim( name00, values00 );

    /* Add a discrete variable called "OppDealtCards" to the domain,
       with states "samesuit", "connected", "pair", "other". */
    String     name01 = "OppDealtCards";
    String[] values01 = new String[]{ "samesuit", "connected", "pair", "other" };
    int          id01 = domain.addDim( name01, values01 );

    /* Add a discrete variable called "Board4" to the domain,
       with states "other", "suit3", "suit4", "rainbow", "straight3", "straight4", "sf3", "triple", "pair", "twopair". */
    String     name02 = "Board4";
    String[] values02 = new String[]{ "other", "suit3", "suit4", "rainbow", "straight3", "straight4", "sf3", "triple", "pair", "twopair" };
    int          id02 = domain.addDim( name02, values02 );

    /* Add a discrete variable called "OppBetBlind" to the domain,
       with states "check", "call", "moderate", "large". */
    String     name03 = "OppBetBlind";
    String[] values03 = new String[]{ "check", "call", "moderate", "large" };
    int          id03 = domain.addDim( name03, values03 );

    /* Add a discrete variable called "OppHand3" to the domain,
       with states "nothing", "pair", "twopair", "triple", "straight", "flush", "fullhouse", "quad", "straightflush". */
    String     name04 = "OppHand3";
    String[] values04 = new String[]{ "nothing", "pair", "twopair", "triple", "straight", "flush", "fullhouse", "quad", "straightflush" };
    int          id04 = domain.addDim( name04, values04 );

    /* Add a discrete variable called "OppHand4" to the domain,
       with states "nothing", "pair", "twopair", "triple", "straight", "flush", "fullhouse", "quad", "straightflush". */
    String     name05 = "OppHand4";
    String[] values05 = new String[]{ "nothing", "pair", "twopair", "triple", "straight", "flush", "fullhouse", "quad", "straightflush" };
    int          id05 = domain.addDim( name05, values05 );

    /* Add a discrete variable called "Board5" to the domain,
       with states "other", "suit3", "suit4", "rainbow", "straight3", "straight4", "sf3", "triple", "pair", "twopair". */
    String     name06 = "Board5";
    String[] values06 = new String[]{ "other", "suit3", "suit4", "rainbow", "straight3", "straight4", "sf3", "triple", "pair", "twopair" };
    int          id06 = domain.addDim( name06, values06 );

    /* Add a discrete variable called "OppBet3" to the domain,
       with states "check", "call", "small", "moderate", "large". */
    String     name07 = "OppBet3";
    String[] values07 = new String[]{ "check", "call", "small", "moderate", "large" };
    int          id07 = domain.addDim( name07, values07 );

    /* Add a discrete variable called "OppBet4" to the domain,
       with states "check", "call", "small", "moderate", "large". */
    String     name08 = "OppBet4";
    String[] values08 = new String[]{ "check", "call", "small", "moderate", "large" };
    int          id08 = domain.addDim( name08, values08 );

    /* Add a discrete variable called "OppHand5" to the domain,
       with states "nothing", "pair", "twopair", "triple", "straight", "flush", "fullhouse", "quad", "straightflush". */
    String     name09 = "OppHand5";
    String[] values09 = new String[]{ "nothing", "pair", "twopair", "triple", "straight", "flush", "fullhouse", "quad", "straightflush" };
    int          id09 = domain.addDim( name09, values09 );

    /* Add a discrete variable called "OppBet5" to the domain,
       with states "check", "call", "small", "moderate", "large". */
    String     name10 = "OppBet5";
    String[] values10 = new String[]{ "check", "call", "small", "moderate", "large" };
    int          id10 = domain.addDim( name10, values10 );

    /* For the cpts, create arrays of double-precision floating point values. */
    //Board3    Value
    //other     0.3419
    //suit3     0.05177
    //suit4     0.0
    //rainbow   0.39765
    //straight3 0.03475
    //straight4 0.0
    //sf3       0.00217
    //triple    0.00235
    //pair      0.16941
    //twopair   0.0
    double[] cpt00 = new double[]{ 0.3419, 0.05177, 0.0, 0.39765, 0.03475, 0.0, 0.00217, 0.00235, 0.16941, 0.0 };
    //OppDealtCards Value
    //samesuit      0.2352941
    //connected     0.1568627
    //pair          0.0588235
    //other         0.5490197
    double[] cpt01 = new double[]{ 0.2352941, 0.1568627, 0.0588235, 0.5490197 };
    //Board4    Board3    Value
    //other     other     0.40911
    //other     suit3     0.0
    //other     suit4     0.0
    //other     rainbow   0.5247800000000001
    //other     straight3 0.0
    //other     straight4 0.0
    //other     sf3       0.0
    //other     triple    0.0
    //other     pair      0.0
    //other     twopair   0.0
    //suit3     other     0.14487
    //suit3     suit3     0.7059300000000001
    //suit3     suit4     0.0
    //suit3     rainbow   0.0
    //suit3     straight3 0.0073
    //suit3     straight4 0.0
    //suit3     sf3       0.06077
    //suit3     triple    0.0
    //suit3     pair      0.10982
    //suit3     twopair   0.45247
    //suit4     other     0.00953
    //suit4     suit3     0.17589000000000002
    //suit4     suit4     0.73471
    //suit4     rainbow   0.0
    //suit4     straight3 0.0
    //suit4     straight4 0.0
    //suit4     sf3       0.0
    //suit4     triple    0.0
    //suit4     pair      0.0
    //suit4     twopair   0.0
    //rainbow   other     0.09325
    //rainbow   suit3     0.0
    //rainbow   suit4     0.0
    //rainbow   rainbow   0.23527000000000003
    //rainbow   straight3 0.00784
    //rainbow   straight4 0.0
    //rainbow   sf3       0.0
    //rainbow   triple    0.0
    //rainbow   pair      0.1178
    //rainbow   twopair   0.0
    //straight3 other     0.08689
    //straight3 suit3     0.057710000000000004
    //straight3 suit4     0.08557
    //straight3 rainbow   0.10859000000000002
    //straight3 straight3 0.72735
    //straight3 straight4 0.09655
    //straight3 sf3       0.0
    //straight3 triple    0.0
    //straight3 pair      0.02009
    //straight3 twopair   0.00599
    //straight4 other     0.00879
    //straight4 suit3     0.004230000000000001
    //straight4 suit4     0.01413
    //straight4 rainbow   0.011330000000000002
    //straight4 straight3 0.13717
    //straight4 straight4 0.76837
    //straight4 sf3       0.0
    //straight4 triple    0.0
    //straight4 pair      0.0
    //straight4 twopair   0.0
    //sf3       other     0.00738
    //sf3       suit3     0.056240000000000005
    //sf3       suit4     0.16559
    //sf3       rainbow   0.0
    //sf3       straight3 0.07349
    //sf3       straight4 0.13508
    //sf3       sf3       0.93923
    //sf3       triple    0.0
    //sf3       pair      0.00282
    //sf3       twopair   0.00568
    //triple    other     0.00955
    //triple    suit3     0.0
    //triple    suit4     0.0
    //triple    rainbow   0.0
    //triple    straight3 0.0
    //triple    straight4 0.0
    //triple    sf3       0.0
    //triple    triple    1.0
    //triple    pair      0.04219
    //triple    twopair   0.08275
    //pair      other     0.22159
    //pair      suit3     0.0
    //pair      suit4     0.0
    //pair      rainbow   0.12003000000000001
    //pair      straight3 0.04685
    //pair      straight4 0.0
    //pair      sf3       0.0
    //pair      triple    0.0
    //pair      pair      0.65646
    //pair      twopair   0.0
    //twopair   other     0.00904
    //twopair   suit3     0.0
    //twopair   suit4     0.0
    //twopair   rainbow   0.0
    //twopair   straight3 0.0
    //twopair   straight4 0.0
    //twopair   sf3       0.0
    //twopair   triple    0.0
    //twopair   pair      0.05082
    //twopair   twopair   0.45311
    double[] cpt02 = new double[]{ 0.40911, 0.0, 0.0, 0.5247800000000001, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.14487, 0.7059300000000001, 0.0, 0.0, 0.0073, 0.0, 0.06077, 0.0, 0.10982, 0.45247, 0.00953, 0.17589000000000002, 0.73471, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.09325, 0.0, 0.0, 0.23527000000000003, 0.00784, 0.0, 0.0, 0.0, 0.1178, 0.0, 0.08689, 0.057710000000000004, 0.08557, 0.10859000000000002, 0.72735, 0.09655, 0.0, 0.0, 0.02009, 0.00599, 0.00879, 0.004230000000000001, 0.01413, 0.011330000000000002, 0.13717, 0.76837, 0.0, 0.0, 0.0, 0.0, 0.00738, 0.056240000000000005, 0.16559, 0.0, 0.07349, 0.13508, 0.93923, 0.0, 0.00282, 0.00568, 0.00955, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.04219, 0.08275, 0.22159, 0.0, 0.0, 0.12003000000000001, 0.04685, 0.0, 0.0, 0.0, 0.65646, 0.0, 0.00904, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.05082, 0.45311 };
    //OppBetBlind OppDealtCards Value
    //check       samesuit      0.35
    //check       connected     0.35
    //check       pair          0.30000000000000004
    //check       other         0.4
    //call        samesuit      0.35
    //call        connected     0.35
    //call        pair          0.30000000000000004
    //call        other         0.4
    //moderate    samesuit      0.25
    //moderate    connected     0.25
    //moderate    pair          0.30000000000000004
    //moderate    other         0.15
    //large       samesuit      0.05
    //large       connected     0.05
    //large       pair          0.1
    //large       other         0.05
    double[] cpt03 = new double[]{ 0.35, 0.35, 0.30000000000000004, 0.4, 0.35, 0.35, 0.30000000000000004, 0.4, 0.25, 0.25, 0.30000000000000004, 0.15, 0.05, 0.05, 0.1, 0.05 };
    //OppHand3      OppDealtCards Board3    Value
    //nothing       samesuit      other     0.5278
    //nothing       samesuit      suit3     0.4765
    //nothing       samesuit      suit4     0.3842
    //nothing       samesuit      rainbow   0.6515000000000001
    //nothing       samesuit      straight3 0.5998
    //nothing       samesuit      straight4 0.2996
    //nothing       samesuit      sf3       0.5238
    //nothing       samesuit      triple    0.0
    //nothing       samesuit      pair      0.0
    //nothing       samesuit      twopair   0.0
    //nothing       connected     other     0.5229
    //nothing       connected     suit3     0.5985
    //nothing       connected     suit4     0.2827
    //nothing       connected     rainbow   0.6321
    //nothing       connected     straight3 0.593
    //nothing       connected     straight4 0.5114000000000001
    //nothing       connected     sf3       0.5278
    //nothing       connected     triple    0.0
    //nothing       connected     pair      0.0
    //nothing       connected     twopair   0.0
    //nothing       pair          other     0.0
    //nothing       pair          suit3     0.0
    //nothing       pair          suit4     0.0
    //nothing       pair          rainbow   0.0
    //nothing       pair          straight3 0.0
    //nothing       pair          straight4 0.0
    //nothing       pair          sf3       0.0
    //nothing       pair          triple    0.0
    //nothing       pair          pair      0.0
    //nothing       pair          twopair   0.0
    //nothing       other         other     0.49710000000000004
    //nothing       other         suit3     0.5713000000000001
    //nothing       other         suit4     0.2769
    //nothing       other         rainbow   0.6126
    //nothing       other         straight3 0.5567
    //nothing       other         straight4 0.2866
    //nothing       other         sf3       0.5042
    //nothing       other         triple    0.0
    //nothing       other         pair      0.0
    //nothing       other         twopair   0.0
    //pair          samesuit      other     0.3991
    //pair          samesuit      suit3     0.3179
    //pair          samesuit      suit4     0.395
    //pair          samesuit      rainbow   0.32360000000000005
    //pair          samesuit      straight3 0.331
    //pair          samesuit      straight4 0.392
    //pair          samesuit      sf3       0.4054
    //pair          samesuit      triple    0.0
    //pair          samesuit      pair      0.7949
    //pair          samesuit      twopair   0.0
    //pair          connected     other     0.4072
    //pair          connected     suit3     0.3227
    //pair          connected     suit4     0.3049
    //pair          connected     rainbow   0.3266
    //pair          connected     straight3 0.1283
    //pair          connected     straight4 0.13710000000000003
    //pair          connected     sf3       0.4028
    //pair          connected     triple    0.0
    //pair          connected     pair      0.7945
    //pair          connected     twopair   0.0
    //pair          pair          other     0.7194
    //pair          pair          suit3     0.8692
    //pair          pair          suit4     0.4118
    //pair          pair          rainbow   0.8656
    //pair          pair          straight3 0.8697
    //pair          pair          straight4 0.6269
    //pair          pair          sf3       0.7265
    //pair          pair          triple    0.0
    //pair          pair          pair      0.0
    //pair          pair          twopair   0.0
    //pair          other         other     0.42510000000000003
    //pair          other         suit3     0.35620000000000007
    //pair          other         suit4     0.3069
    //pair          other         rainbow   0.354
    //pair          other         straight3 0.3709
    //pair          other         straight4 0.4045
    //pair          other         sf3       0.4131
    //pair          other         triple    0.0
    //pair          other         pair      0.7415
    //pair          other         twopair   0.0
    //twopair       samesuit      other     0.0435
    //twopair       samesuit      suit3     0.0329
    //twopair       samesuit      suit4     0.0706
    //twopair       samesuit      rainbow   0.021400000000000002
    //twopair       samesuit      straight3 0.0264
    //twopair       samesuit      straight4 0.0514
    //twopair       samesuit      sf3       0.0429
    //twopair       samesuit      triple    0.0
    //twopair       samesuit      pair      0.1199
    //twopair       samesuit      twopair   0.8367
    //twopair       connected     other     0.0397
    //twopair       connected     suit3     0.0238
    //twopair       connected     suit4     0.0481
    //twopair       connected     rainbow   0.0291
    //twopair       connected     straight3 0.1077
    //twopair       connected     straight4 0.17370000000000002
    //twopair       connected     sf3       0.0416
    //twopair       connected     triple    0.0
    //twopair       connected     pair      0.1198
    //twopair       connected     twopair   0.8324
    //twopair       pair          other     0.1628
    //twopair       pair          suit3     0.0
    //twopair       pair          suit4     0.0
    //twopair       pair          rainbow   0.0
    //twopair       pair          straight3 0.0
    //twopair       pair          straight4 0.0
    //twopair       pair          sf3       0.1563
    //twopair       pair          triple    0.0
    //twopair       pair          pair      0.9416
    //twopair       pair          twopair   0.9728
    //twopair       other         other     0.05020000000000001
    //twopair       other         suit3     0.022000000000000002
    //twopair       other         suit4     0.0483
    //twopair       other         rainbow   0.0218
    //twopair       other         straight3 0.0238
    //twopair       other         straight4 0.0528
    //twopair       other         sf3       0.0534
    //twopair       other         triple    0.0
    //twopair       other         pair      0.1687
    //twopair       other         twopair   0.8442000000000001
    //triple        samesuit      other     0.0142
    //triple        samesuit      suit3     0.0
    //triple        samesuit      suit4     0.0
    //triple        samesuit      rainbow   0.0
    //triple        samesuit      straight3 0.0
    //triple        samesuit      straight4 0.0
    //triple        samesuit      sf3       0.0152
    //triple        samesuit      triple    0.9551
    //triple        samesuit      pair      0.08
    //triple        samesuit      twopair   0.0071
    //triple        connected     other     0.0164
    //triple        connected     suit3     0.0
    //triple        connected     suit4     0.0
    //triple        connected     rainbow   0.0
    //triple        connected     straight3 0.0
    //triple        connected     straight4 0.0
    //triple        connected     sf3       0.0152
    //triple        connected     triple    0.9566
    //triple        connected     pair      0.0792
    //triple        connected     twopair   0.0039
    //triple        pair          other     0.1051
    //triple        pair          suit3     0.1308
    //triple        pair          suit4     0.1861
    //triple        pair          rainbow   0.1344
    //triple        pair          straight3 0.1303
    //triple        pair          straight4 0.1898
    //triple        pair          sf3       0.1053
    //triple        pair          triple    0.0
    //triple        pair          pair      0.0
    //triple        pair          twopair   0.0
    //triple        other         other     0.02030000000000001
    //triple        other         suit3     0.008400000000000001
    //triple        other         suit4     0.0091
    //triple        other         rainbow   0.0074
    //triple        other         straight3 0.0081
    //triple        other         straight4 0.0112
    //triple        other         sf3       0.0211
    //triple        other         triple    0.9014
    //triple        other         pair      0.0785
    //triple        other         twopair   0.0035000000000000005
    //straight      samesuit      other     0.0041
    //straight      samesuit      suit3     0.0032
    //straight      samesuit      suit4     0.014
    //straight      samesuit      rainbow   0.0034000000000000002
    //straight      samesuit      straight3 0.0305
    //straight      samesuit      straight4 0.2158
    //straight      samesuit      sf3       0.0035
    //straight      samesuit      triple    0.0
    //straight      samesuit      pair      0.0
    //straight      samesuit      twopair   0.0
    //straight      connected     other     0.0101
    //straight      connected     suit3     0.0101
    //straight      connected     suit4     0.0197
    //straight      connected     rainbow   0.0121
    //straight      connected     straight3 0.1602
    //straight      connected     straight4 0.15530000000000002
    //straight      connected     sf3       0.0092
    //straight      connected     triple    0.0
    //straight      connected     pair      0.0
    //straight      connected     twopair   0.0
    //straight      pair          other     0.0
    //straight      pair          suit3     0.0
    //straight      pair          suit4     4.0E-4
    //straight      pair          rainbow   0.0
    //straight      pair          straight3 0.0
    //straight      pair          straight4 0.1688
    //straight      pair          sf3       0.0
    //straight      pair          triple    0.0
    //straight      pair          pair      0.0
    //straight      pair          twopair   0.0
    //straight      other         other     0.0036000000000000003
    //straight      other         suit3     0.003299999999999999
    //straight      other         suit4     0.0094
    //straight      other         rainbow   0.004
    //straight      other         straight3 0.0359
    //straight      other         straight4 0.2245
    //straight      other         sf3       0.0038
    //straight      other         triple    0.0
    //straight      other         pair      0.0
    //straight      other         twopair   0.0
    //flush         samesuit      other     0.0101
    //flush         samesuit      suit3     0.1684
    //flush         samesuit      suit4     0.1295
    //flush         samesuit      rainbow   0.0
    //flush         samesuit      straight3 0.0094
    //flush         samesuit      straight4 0.0318
    //flush         samesuit      sf3       0.0086
    //flush         samesuit      triple    0.0
    //flush         samesuit      pair      0.0
    //flush         samesuit      twopair   0.0
    //flush         connected     other     0.002
    //flush         connected     suit3     0.0418
    //flush         connected     suit4     0.3367
    //flush         connected     rainbow   0.0
    //flush         connected     straight3 0.0022
    //flush         connected     straight4 0.011200000000000002
    //flush         connected     sf3       0.0019
    //flush         connected     triple    0.0
    //flush         connected     pair      0.0
    //flush         connected     twopair   0.0
    //flush         pair          other     0.0
    //flush         pair          suit3     0.0
    //flush         pair          suit4     0.398
    //flush         pair          rainbow   0.0
    //flush         pair          straight3 0.0
    //flush         pair          straight4 0.0053
    //flush         pair          sf3       0.0
    //flush         pair          triple    0.0
    //flush         pair          pair      0.0
    //flush         pair          twopair   0.0
    //flush         other         other     0.002100000000000001
    //flush         other         suit3     0.038400000000000004
    //flush         other         suit4     0.3454
    //flush         other         rainbow   0.0
    //flush         other         straight3 0.0021
    //flush         other         straight4 0.0121
    //flush         other         sf3       0.0026
    //flush         other         triple    0.0
    //flush         other         pair      0.0
    //flush         other         twopair   0.0
    //fullhouse     samesuit      other     9.0E-4
    //fullhouse     samesuit      suit3     0.0
    //fullhouse     samesuit      suit4     0.0
    //fullhouse     samesuit      rainbow   0.0
    //fullhouse     samesuit      straight3 0.0
    //fullhouse     samesuit      straight4 0.0
    //fullhouse     samesuit      sf3       3.0E-4
    //fullhouse     samesuit      triple    0.0
    //fullhouse     samesuit      pair      0.0052
    //fullhouse     samesuit      twopair   0.1562
    //fullhouse     connected     other     0.001
    //fullhouse     connected     suit3     0.0
    //fullhouse     connected     suit4     0.0
    //fullhouse     connected     rainbow   0.0
    //fullhouse     connected     straight3 0.0
    //fullhouse     connected     straight4 0.0
    //fullhouse     connected     sf3       0.0011
    //fullhouse     connected     triple    0.0
    //fullhouse     connected     pair      0.0065
    //fullhouse     connected     twopair   0.1637
    //fullhouse     pair          other     0.0099
    //fullhouse     pair          suit3     0.0
    //fullhouse     pair          suit4     0.0
    //fullhouse     pair          rainbow   0.0
    //fullhouse     pair          straight3 0.0
    //fullhouse     pair          straight4 0.0
    //fullhouse     pair          sf3       0.0102
    //fullhouse     pair          triple    1.0
    //fullhouse     pair          pair      0.0424
    //fullhouse     pair          twopair   0.0
    //fullhouse     other         other     0.0012000000000000005
    //fullhouse     other         suit3     0.0
    //fullhouse     other         suit4     0.0
    //fullhouse     other         rainbow   0.0
    //fullhouse     other         straight3 0.0
    //fullhouse     other         straight4 0.0
    //fullhouse     other         sf3       0.0012
    //fullhouse     other         triple    0.0606
    //fullhouse     other         pair      0.0102
    //fullhouse     other         twopair   0.15050000000000002
    //quad          samesuit      other     1.0E-4
    //quad          samesuit      suit3     0.0
    //quad          samesuit      suit4     0.0
    //quad          samesuit      rainbow   0.0
    //quad          samesuit      straight3 0.0
    //quad          samesuit      straight4 0.0
    //quad          samesuit      sf3       1.0E-4
    //quad          samesuit      triple    0.0449
    //quad          samesuit      pair      0.0
    //quad          samesuit      twopair   0.0
    //quad          connected     other     1.0E-4
    //quad          connected     suit3     0.0
    //quad          connected     suit4     0.0
    //quad          connected     rainbow   0.0
    //quad          connected     straight3 0.0
    //quad          connected     straight4 0.0
    //quad          connected     sf3       1.0E-4
    //quad          connected     triple    0.0434
    //quad          connected     pair      0.0
    //quad          connected     twopair   0.0
    //quad          pair          other     0.0028
    //quad          pair          suit3     0.0
    //quad          pair          suit4     0.0
    //quad          pair          rainbow   0.0
    //quad          pair          straight3 0.0
    //quad          pair          straight4 0.0
    //quad          pair          sf3       0.0017
    //quad          pair          triple    0.0
    //quad          pair          pair      0.016
    //quad          pair          twopair   0.0272
    //quad          other         other     1.0000000000000002E-4
    //quad          other         suit3     0.0
    //quad          other         suit4     0.0
    //quad          other         rainbow   0.0
    //quad          other         straight3 0.0
    //quad          other         straight4 0.0
    //quad          other         sf3       3.0E-4
    //quad          other         triple    0.038
    //quad          other         pair      0.0011
    //quad          other         twopair   0.0018000000000000002
    //straightflush samesuit      other     2.0E-4
    //straightflush samesuit      suit3     0.0011
    //straightflush samesuit      suit4     0.0067
    //straightflush samesuit      rainbow   1.0000000000000002E-4
    //straightflush samesuit      straight3 0.0029
    //straightflush samesuit      straight4 0.0094
    //straightflush samesuit      sf3       2.0E-4
    //straightflush samesuit      triple    0.0
    //straightflush samesuit      pair      0.0
    //straightflush samesuit      twopair   0.0
    //straightflush connected     other     6.0E-4
    //straightflush connected     suit3     0.0031
    //straightflush connected     suit4     0.0079
    //straightflush connected     rainbow   1.0E-4
    //straightflush connected     straight3 0.0086
    //straightflush connected     straight4 0.011300000000000001
    //straightflush connected     sf3       3.0E-4
    //straightflush connected     triple    0.0
    //straightflush connected     pair      0.0
    //straightflush connected     twopair   0.0
    //straightflush pair          other     0.0
    //straightflush pair          suit3     0.0
    //straightflush pair          suit4     0.0037
    //straightflush pair          rainbow   0.0
    //straightflush pair          straight3 0.0
    //straightflush pair          straight4 0.0092
    //straightflush pair          sf3       0.0
    //straightflush pair          triple    0.0
    //straightflush pair          pair      0.0
    //straightflush pair          twopair   0.0
    //straightflush other         other     3.0000000000000014E-4
    //straightflush other         suit3     3.999999999999999E-4
    //straightflush other         suit4     0.004
    //straightflush other         rainbow   2.0E-4
    //straightflush other         straight3 0.0025
    //straightflush other         straight4 0.0083
    //straightflush other         sf3       3.0E-4
    //straightflush other         triple    0.0
    //straightflush other         pair      0.0
    //straightflush other         twopair   0.0
    double[] cpt04 = new double[]{ 0.5278, 0.4765, 0.3842, 0.6515000000000001, 0.5998, 0.2996, 0.5238, 0.0, 0.0, 0.0, 0.5229, 0.5985, 0.2827, 0.6321, 0.593, 0.5114000000000001, 0.5278, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.49710000000000004, 0.5713000000000001, 0.2769, 0.6126, 0.5567, 0.2866, 0.5042, 0.0, 0.0, 0.0, 0.3991, 0.3179, 0.395, 0.32360000000000005, 0.331, 0.392, 0.4054, 0.0, 0.7949, 0.0, 0.4072, 0.3227, 0.3049, 0.3266, 0.1283, 0.13710000000000003, 0.4028, 0.0, 0.7945, 0.0, 0.7194, 0.8692, 0.4118, 0.8656, 0.8697, 0.6269, 0.7265, 0.0, 0.0, 0.0, 0.42510000000000003, 0.35620000000000007, 0.3069, 0.354, 0.3709, 0.4045, 0.4131, 0.0, 0.7415, 0.0, 0.0435, 0.0329, 0.0706, 0.021400000000000002, 0.0264, 0.0514, 0.0429, 0.0, 0.1199, 0.8367, 0.0397, 0.0238, 0.0481, 0.0291, 0.1077, 0.17370000000000002, 0.0416, 0.0, 0.1198, 0.8324, 0.1628, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1563, 0.0, 0.9416, 0.9728, 0.05020000000000001, 0.022000000000000002, 0.0483, 0.0218, 0.0238, 0.0528, 0.0534, 0.0, 0.1687, 0.8442000000000001, 0.0142, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0152, 0.9551, 0.08, 0.0071, 0.0164, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0152, 0.9566, 0.0792, 0.0039, 0.1051, 0.1308, 0.1861, 0.1344, 0.1303, 0.1898, 0.1053, 0.0, 0.0, 0.0, 0.02030000000000001, 0.008400000000000001, 0.0091, 0.0074, 0.0081, 0.0112, 0.0211, 0.9014, 0.0785, 0.0035000000000000005, 0.0041, 0.0032, 0.014, 0.0034000000000000002, 0.0305, 0.2158, 0.0035, 0.0, 0.0, 0.0, 0.0101, 0.0101, 0.0197, 0.0121, 0.1602, 0.15530000000000002, 0.0092, 0.0, 0.0, 0.0, 0.0, 0.0, 4.0E-4, 0.0, 0.0, 0.1688, 0.0, 0.0, 0.0, 0.0, 0.0036000000000000003, 0.003299999999999999, 0.0094, 0.004, 0.0359, 0.2245, 0.0038, 0.0, 0.0, 0.0, 0.0101, 0.1684, 0.1295, 0.0, 0.0094, 0.0318, 0.0086, 0.0, 0.0, 0.0, 0.002, 0.0418, 0.3367, 0.0, 0.0022, 0.011200000000000002, 0.0019, 0.0, 0.0, 0.0, 0.0, 0.0, 0.398, 0.0, 0.0, 0.0053, 0.0, 0.0, 0.0, 0.0, 0.002100000000000001, 0.038400000000000004, 0.3454, 0.0, 0.0021, 0.0121, 0.0026, 0.0, 0.0, 0.0, 9.0E-4, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0E-4, 0.0, 0.0052, 0.1562, 0.001, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0011, 0.0, 0.0065, 0.1637, 0.0099, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0102, 1.0, 0.0424, 0.0, 0.0012000000000000005, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0012, 0.0606, 0.0102, 0.15050000000000002, 1.0E-4, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4, 0.0449, 0.0, 0.0, 1.0E-4, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4, 0.0434, 0.0, 0.0, 0.0028, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0017, 0.0, 0.016, 0.0272, 1.0000000000000002E-4, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0E-4, 0.038, 0.0011, 0.0018000000000000002, 2.0E-4, 0.0011, 0.0067, 1.0000000000000002E-4, 0.0029, 0.0094, 2.0E-4, 0.0, 0.0, 0.0, 6.0E-4, 0.0031, 0.0079, 1.0E-4, 0.0086, 0.011300000000000001, 3.0E-4, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0037, 0.0, 0.0, 0.0092, 0.0, 0.0, 0.0, 0.0, 3.0000000000000014E-4, 3.999999999999999E-4, 0.004, 2.0E-4, 0.0025, 0.0083, 3.0E-4, 0.0, 0.0, 0.0 };
    //OppHand4      Board4    OppDealtCards Value
    //nothing       other     samesuit      0.335
    //nothing       other     connected     0.3396
    //nothing       other     pair          0.0
    //nothing       other     other         0.3315000000000001
    //nothing       suit3     samesuit      0.3034
    //nothing       suit3     connected     0.3642
    //nothing       suit3     pair          0.0
    //nothing       suit3     other         0.3451
    //nothing       suit4     samesuit      0.3838
    //nothing       suit4     connected     0.2807
    //nothing       suit4     pair          0.0
    //nothing       suit4     other         0.2825
    //nothing       rainbow   samesuit      0.5245000000000001
    //nothing       rainbow   connected     0.5049000000000001
    //nothing       rainbow   pair          0.0
    //nothing       rainbow   other         0.4944
    //nothing       straight3 samesuit      0.35360000000000014
    //nothing       straight3 connected     0.3836
    //nothing       straight3 pair          0.0
    //nothing       straight3 other         0.3447
    //nothing       straight4 samesuit      0.3009
    //nothing       straight4 connected     0.5076
    //nothing       straight4 pair          0.0
    //nothing       straight4 other         0.2854
    //nothing       sf3       samesuit      0.3398
    //nothing       sf3       connected     0.3443
    //nothing       sf3       pair          0.0
    //nothing       sf3       other         0.32960000000000006
    //nothing       triple    samesuit      0.0
    //nothing       triple    connected     0.0
    //nothing       triple    pair          0.0
    //nothing       triple    other         0.0
    //nothing       pair      samesuit      0.0
    //nothing       pair      connected     0.0
    //nothing       pair      pair          0.0
    //nothing       pair      other         0.0
    //nothing       twopair   samesuit      0.0
    //nothing       twopair   connected     0.0
    //nothing       twopair   pair          0.0
    //nothing       twopair   other         0.0
    //pair          other     samesuit      0.4715
    //pair          other     connected     0.4699
    //pair          other     pair          0.5426000000000001
    //pair          other     other         0.4773
    //pair          suit3     samesuit      0.3976
    //pair          suit3     connected     0.4512
    //pair          suit3     pair          0.6235
    //pair          suit3     other         0.4607
    //pair          suit4     samesuit      0.3995
    //pair          suit4     connected     0.2943
    //pair          suit4     pair          0.4002
    //pair          suit4     other         0.3032
    //pair          rainbow   samesuit      0.4032
    //pair          rainbow   connected     0.4048999999999999
    //pair          rainbow   pair          0.8132
    //pair          rainbow   other         0.4285
    //pair          straight3 samesuit      0.4431
    //pair          straight3 connected     0.3273
    //pair          straight3 pair          0.6351000000000001
    //pair          straight3 other         0.4587
    //pair          straight4 samesuit      0.3899
    //pair          straight4 connected     0.1358
    //pair          straight4 pair          0.6239000000000001
    //pair          straight4 other         0.4029
    //pair          sf3       samesuit      0.4675
    //pair          sf3       connected     0.4692
    //pair          sf3       pair          0.5436000000000001
    //pair          sf3       other         0.47020000000000006
    //pair          triple    samesuit      0.0
    //pair          triple    connected     0.0
    //pair          triple    pair          0.0
    //pair          triple    other         0.0
    //pair          pair      samesuit      0.6519
    //pair          pair      connected     0.66
    //pair          pair      pair          0.0
    //pair          pair      other         0.6273
    //pair          twopair   samesuit      0.0
    //pair          twopair   connected     0.0
    //pair          twopair   pair          0.0
    //pair          twopair   other         0.0
    //twopair       other     samesuit      0.1132
    //twopair       other     connected     0.1152
    //twopair       other     pair          0.2916000000000001
    //twopair       other     other         0.1207
    //twopair       suit3     samesuit      0.1003
    //twopair       suit3     connected     0.097
    //twopair       suit3     pair          0.2129
    //twopair       suit3     other         0.1057
    //twopair       suit4     samesuit      0.0654
    //twopair       suit4     connected     0.05229999999999998
    //twopair       suit4     pair          0.0
    //twopair       suit4     other         0.0475
    //twopair       rainbow   samesuit      0.0498
    //twopair       rainbow   connected     0.051399999999999994
    //twopair       rainbow   pair          0.0
    //twopair       rainbow   other         0.0459
    //twopair       straight3 samesuit      0.08300000000000003
    //twopair       straight3 connected     0.1227
    //twopair       straight3 pair          0.17250000000000001
    //twopair       straight3 other         0.0872
    //twopair       straight4 samesuit      0.0568
    //twopair       straight4 connected     0.1756
    //twopair       straight4 pair          0.0
    //twopair       straight4 other         0.0527
    //twopair       sf3       samesuit      0.115
    //twopair       sf3       connected     0.1145
    //twopair       sf3       pair          0.28440000000000004
    //twopair       sf3       other         0.12960000000000002
    //twopair       triple    samesuit      0.0
    //twopair       triple    connected     0.0
    //twopair       triple    pair          0.0
    //twopair       triple    other         0.0
    //twopair       pair      samesuit      0.2409
    //twopair       pair      connected     0.2371999999999999
    //twopair       pair      pair          0.8948
    //twopair       pair      other         0.2781
    //twopair       twopair   samesuit      0.8283
    //twopair       twopair   connected     0.8263
    //twopair       twopair   pair          0.971
    //twopair       twopair   other         0.8368000000000001
    //triple        other     samesuit      0.03
    //triple        other     connected     0.0303
    //triple        other     pair          0.11830000000000002
    //triple        other     other         0.038400000000000004
    //triple        suit3     samesuit      0.015
    //triple        suit3     connected     0.0174
    //triple        suit3     pair          0.1351
    //triple        suit3     other         0.0308
    //triple        suit4     samesuit      0.0
    //triple        suit4     connected     0.0
    //triple        suit4     pair          0.1882
    //triple        suit4     other         0.0109
    //triple        rainbow   samesuit      0.0
    //triple        rainbow   connected     0.0
    //triple        rainbow   pair          0.1833
    //triple        rainbow   other         0.0106
    //triple        straight3 samesuit      0.0151
    //triple        straight3 connected     0.0067
    //triple        straight3 pair          0.14310000000000003
    //triple        straight3 other         0.0224
    //triple        straight4 samesuit      0.0
    //triple        straight4 connected     0.0
    //triple        straight4 pair          0.18970000000000004
    //triple        straight4 other         0.0118
    //triple        sf3       samesuit      0.0304
    //triple        sf3       connected     0.0285
    //triple        sf3       pair          0.12370000000000002
    //triple        sf3       other         0.035500000000000004
    //triple        triple    samesuit      0.8341000000000001
    //triple        triple    connected     0.8349
    //triple        triple    pair          0.0435
    //triple        triple    other         0.7887
    //triple        pair      samesuit      0.0735
    //triple        pair      connected     0.0811
    //triple        pair      pair          0.0
    //triple        pair      other         0.072
    //triple        twopair   samesuit      0.0074
    //triple        twopair   connected     0.0047
    //triple        twopair   pair          0.0
    //triple        twopair   other         0.0023000000000000004
    //straight      other     samesuit      0.0147
    //straight      other     connected     0.0265
    //straight      other     pair          0.0014000000000000002
    //straight      other     other         0.0129
    //straight      suit3     samesuit      0.0128
    //straight      suit3     connected     0.0249
    //straight      suit3     pair          0.0021
    //straight      suit3     other         0.0145
    //straight      suit4     samesuit      0.0161
    //straight      suit4     connected     0.0215
    //straight      suit4     pair          4.0E-4
    //straight      suit4     other         0.0116
    //straight      rainbow   samesuit      0.022200000000000004
    //straight      rainbow   connected     0.03860000000000001
    //straight      rainbow   pair          0.0035
    //straight      rainbow   other         0.0205
    //straight      straight3 samesuit      0.06450000000000003
    //straight      straight3 connected     0.1315
    //straight      straight3 pair          0.021700000000000004
    //straight      straight3 other         0.0682
    //straight      straight4 samesuit      0.2133
    //straight      straight4 connected     0.157
    //straight      straight4 pair          0.17570000000000002
    //straight      straight4 other         0.2266
    //straight      sf3       samesuit      0.0129
    //straight      sf3       connected     0.0262
    //straight      sf3       pair          0.0023000000000000004
    //straight      sf3       other         0.015900000000000004
    //straight      triple    samesuit      0.0
    //straight      triple    connected     0.0
    //straight      triple    pair          0.0
    //straight      triple    other         0.0
    //straight      pair      samesuit      0.0017
    //straight      pair      connected     0.006099999999999998
    //straight      pair      pair          0.0
    //straight      pair      other         0.0013
    //straight      twopair   samesuit      0.0
    //straight      twopair   connected     0.0
    //straight      twopair   pair          0.0
    //straight      twopair   other         0.0
    //flush         other     samesuit      0.0282
    //flush         other     connected     0.0097
    //flush         other     pair          0.0033000000000000004
    //flush         other     other         0.010300000000000002
    //flush         suit3     samesuit      0.1659
    //flush         suit3     connected     0.0398
    //flush         suit3     pair          0.0
    //flush         suit3     other         0.0389
    //flush         suit4     samesuit      0.1284
    //flush         suit4     connected     0.3437
    //flush         suit4     pair          0.4075
    //flush         suit4     other         0.3395
    //flush         rainbow   samesuit      0.0
    //flush         rainbow   connected     0.0
    //flush         rainbow   pair          0.0
    //flush         rainbow   other         0.0
    //flush         straight3 samesuit      0.03550000000000001
    //flush         straight3 connected     0.0125
    //flush         straight3 pair          0.006500000000000001
    //flush         straight3 other         0.0126
    //flush         straight4 samesuit      0.0311
    //flush         straight4 connected     0.011
    //flush         straight4 pair          0.0045000000000000005
    //flush         straight4 other         0.0109
    //flush         sf3       samesuit      0.028
    //flush         sf3       connected     0.0104
    //flush         sf3       pair          0.004200000000000001
    //flush         sf3       other         0.010400000000000001
    //flush         triple    samesuit      0.0
    //flush         triple    connected     0.0
    //flush         triple    pair          0.0
    //flush         triple    other         0.0
    //flush         pair      samesuit      0.0214
    //flush         pair      connected     0.0047
    //flush         pair      pair          0.0
    //flush         pair      other         0.0051
    //flush         twopair   samesuit      0.0
    //flush         twopair   connected     0.0
    //flush         twopair   pair          0.0
    //flush         twopair   other         0.0
    //fullhouse     other     samesuit      0.0059
    //fullhouse     other     connected     0.0073
    //fullhouse     other     pair          0.03760000000000001
    //fullhouse     other     other         0.008000000000000002
    //fullhouse     suit3     samesuit      0.0036
    //fullhouse     suit3     connected     0.0028
    //fullhouse     suit3     pair          0.023
    //fullhouse     suit3     other         0.0029
    //fullhouse     suit4     samesuit      0.0
    //fullhouse     suit4     connected     0.0
    //fullhouse     suit4     pair          0.0
    //fullhouse     suit4     other         0.0
    //fullhouse     rainbow   samesuit      0.0
    //fullhouse     rainbow   connected     0.0
    //fullhouse     rainbow   pair          0.0
    //fullhouse     rainbow   other         0.0
    //fullhouse     straight3 samesuit      0.0017
    //fullhouse     straight3 connected     0.011
    //fullhouse     straight3 pair          0.015400000000000002
    //fullhouse     straight3 other         0.0027
    //fullhouse     straight4 samesuit      0.0
    //fullhouse     straight4 connected     0.0
    //fullhouse     straight4 pair          0.0
    //fullhouse     straight4 other         0.0
    //fullhouse     sf3       samesuit      0.0054
    //fullhouse     sf3       connected     0.0057
    //fullhouse     sf3       pair          0.03590000000000001
    //fullhouse     sf3       other         0.008000000000000002
    //fullhouse     triple    samesuit      0.11930000000000002
    //fullhouse     triple    connected     0.119
    //fullhouse     triple    pair          0.9565
    //fullhouse     triple    other         0.1712
    //fullhouse     pair      samesuit      0.0104
    //fullhouse     pair      connected     0.0104
    //fullhouse     pair      pair          0.0893
    //fullhouse     pair      other         0.015599999999999994
    //fullhouse     twopair   samesuit      0.1643
    //fullhouse     twopair   connected     0.169
    //fullhouse     twopair   pair          0.0
    //fullhouse     twopair   other         0.15850000000000003
    //quad          other     samesuit      6.0E-4
    //quad          other     connected     7.0E-4
    //quad          other     pair          0.005000000000000001
    //quad          other     other         5.000000000000001E-4
    //quad          suit3     samesuit      0.0
    //quad          suit3     connected     0.0
    //quad          suit3     pair          0.003
    //quad          suit3     other         2.0E-4
    //quad          suit4     samesuit      0.0
    //quad          suit4     connected     0.0
    //quad          suit4     pair          0.0
    //quad          suit4     other         0.0
    //quad          rainbow   samesuit      0.0
    //quad          rainbow   connected     0.0
    //quad          rainbow   pair          0.0
    //quad          rainbow   other         0.0
    //quad          straight3 samesuit      0.0
    //quad          straight3 connected     0.0
    //quad          straight3 pair          0.004200000000000001
    //quad          straight3 other         2.0E-4
    //quad          straight4 samesuit      0.0
    //quad          straight4 connected     0.0
    //quad          straight4 pair          0.0
    //quad          straight4 other         0.0
    //quad          sf3       samesuit      3.0E-4
    //quad          sf3       connected     2.0E-4
    //quad          sf3       pair          0.0055000000000000005
    //quad          sf3       other         5.000000000000001E-4
    //quad          triple    samesuit      0.04660000000000001
    //quad          triple    connected     0.0461
    //quad          triple    pair          0.0
    //quad          triple    other         0.0401
    //quad          pair      samesuit      0.0
    //quad          pair      connected     0.0
    //quad          pair      pair          0.0159
    //quad          pair      other         6.0E-4
    //quad          twopair   samesuit      0.0
    //quad          twopair   connected     0.0
    //quad          twopair   pair          0.029
    //quad          twopair   other         0.0024000000000000002
    //straightflush other     samesuit      9.0E-4
    //straightflush other     connected     8.0E-4
    //straightflush other     pair          2.0000000000000004E-4
    //straightflush other     other         4.0E-4
    //straightflush suit3     samesuit      0.0014
    //straightflush suit3     connected     0.0027
    //straightflush suit3     pair          4.0E-4
    //straightflush suit3     other         0.0012
    //straightflush suit4     samesuit      0.0068
    //straightflush suit4     connected     0.007499999999999997
    //straightflush suit4     pair          0.0037
    //straightflush suit4     other         0.0048
    //straightflush rainbow   samesuit      3.0000000000000003E-4
    //straightflush rainbow   connected     1.9999999999999998E-4
    //straightflush rainbow   pair          0.0
    //straightflush rainbow   other         1.0E-4
    //straightflush straight3 samesuit      0.0035
    //straightflush straight3 connected     0.0047
    //straightflush straight3 pair          0.0015000000000000002
    //straightflush straight3 other         0.0033
    //straightflush straight4 samesuit      0.008
    //straightflush straight4 connected     0.013
    //straightflush straight4 pair          0.006200000000000001
    //straightflush straight4 other         0.0097
    //straightflush sf3       samesuit      7.0E-4
    //straightflush sf3       connected     0.001
    //straightflush sf3       pair          4.000000000000001E-4
    //straightflush sf3       other         3.0000000000000003E-4
    //straightflush triple    samesuit      0.0
    //straightflush triple    connected     0.0
    //straightflush triple    pair          0.0
    //straightflush triple    other         0.0
    //straightflush pair      samesuit      2.0E-4
    //straightflush pair      connected     5.0E-4
    //straightflush pair      pair          0.0
    //straightflush pair      other         0.0
    //straightflush twopair   samesuit      0.0
    //straightflush twopair   connected     0.0
    //straightflush twopair   pair          0.0
    //straightflush twopair   other         0.0
    double[] cpt05 = new double[]{ 0.335, 0.3396, 0.0, 0.3315000000000001, 0.3034, 0.3642, 0.0, 0.3451, 0.3838, 0.2807, 0.0, 0.2825, 0.5245000000000001, 0.5049000000000001, 0.0, 0.4944, 0.35360000000000014, 0.3836, 0.0, 0.3447, 0.3009, 0.5076, 0.0, 0.2854, 0.3398, 0.3443, 0.0, 0.32960000000000006, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.4715, 0.4699, 0.5426000000000001, 0.4773, 0.3976, 0.4512, 0.6235, 0.4607, 0.3995, 0.2943, 0.4002, 0.3032, 0.4032, 0.4048999999999999, 0.8132, 0.4285, 0.4431, 0.3273, 0.6351000000000001, 0.4587, 0.3899, 0.1358, 0.6239000000000001, 0.4029, 0.4675, 0.4692, 0.5436000000000001, 0.47020000000000006, 0.0, 0.0, 0.0, 0.0, 0.6519, 0.66, 0.0, 0.6273, 0.0, 0.0, 0.0, 0.0, 0.1132, 0.1152, 0.2916000000000001, 0.1207, 0.1003, 0.097, 0.2129, 0.1057, 0.0654, 0.05229999999999998, 0.0, 0.0475, 0.0498, 0.051399999999999994, 0.0, 0.0459, 0.08300000000000003, 0.1227, 0.17250000000000001, 0.0872, 0.0568, 0.1756, 0.0, 0.0527, 0.115, 0.1145, 0.28440000000000004, 0.12960000000000002, 0.0, 0.0, 0.0, 0.0, 0.2409, 0.2371999999999999, 0.8948, 0.2781, 0.8283, 0.8263, 0.971, 0.8368000000000001, 0.03, 0.0303, 0.11830000000000002, 0.038400000000000004, 0.015, 0.0174, 0.1351, 0.0308, 0.0, 0.0, 0.1882, 0.0109, 0.0, 0.0, 0.1833, 0.0106, 0.0151, 0.0067, 0.14310000000000003, 0.0224, 0.0, 0.0, 0.18970000000000004, 0.0118, 0.0304, 0.0285, 0.12370000000000002, 0.035500000000000004, 0.8341000000000001, 0.8349, 0.0435, 0.7887, 0.0735, 0.0811, 0.0, 0.072, 0.0074, 0.0047, 0.0, 0.0023000000000000004, 0.0147, 0.0265, 0.0014000000000000002, 0.0129, 0.0128, 0.0249, 0.0021, 0.0145, 0.0161, 0.0215, 4.0E-4, 0.0116, 0.022200000000000004, 0.03860000000000001, 0.0035, 0.0205, 0.06450000000000003, 0.1315, 0.021700000000000004, 0.0682, 0.2133, 0.157, 0.17570000000000002, 0.2266, 0.0129, 0.0262, 0.0023000000000000004, 0.015900000000000004, 0.0, 0.0, 0.0, 0.0, 0.0017, 0.006099999999999998, 0.0, 0.0013, 0.0, 0.0, 0.0, 0.0, 0.0282, 0.0097, 0.0033000000000000004, 0.010300000000000002, 0.1659, 0.0398, 0.0, 0.0389, 0.1284, 0.3437, 0.4075, 0.3395, 0.0, 0.0, 0.0, 0.0, 0.03550000000000001, 0.0125, 0.006500000000000001, 0.0126, 0.0311, 0.011, 0.0045000000000000005, 0.0109, 0.028, 0.0104, 0.004200000000000001, 0.010400000000000001, 0.0, 0.0, 0.0, 0.0, 0.0214, 0.0047, 0.0, 0.0051, 0.0, 0.0, 0.0, 0.0, 0.0059, 0.0073, 0.03760000000000001, 0.008000000000000002, 0.0036, 0.0028, 0.023, 0.0029, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0017, 0.011, 0.015400000000000002, 0.0027, 0.0, 0.0, 0.0, 0.0, 0.0054, 0.0057, 0.03590000000000001, 0.008000000000000002, 0.11930000000000002, 0.119, 0.9565, 0.1712, 0.0104, 0.0104, 0.0893, 0.015599999999999994, 0.1643, 0.169, 0.0, 0.15850000000000003, 6.0E-4, 7.0E-4, 0.005000000000000001, 5.000000000000001E-4, 0.0, 0.0, 0.003, 2.0E-4, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.004200000000000001, 2.0E-4, 0.0, 0.0, 0.0, 0.0, 3.0E-4, 2.0E-4, 0.0055000000000000005, 5.000000000000001E-4, 0.04660000000000001, 0.0461, 0.0, 0.0401, 0.0, 0.0, 0.0159, 6.0E-4, 0.0, 0.0, 0.029, 0.0024000000000000002, 9.0E-4, 8.0E-4, 2.0000000000000004E-4, 4.0E-4, 0.0014, 0.0027, 4.0E-4, 0.0012, 0.0068, 0.007499999999999997, 0.0037, 0.0048, 3.0000000000000003E-4, 1.9999999999999998E-4, 0.0, 1.0E-4, 0.0035, 0.0047, 0.0015000000000000002, 0.0033, 0.008, 0.013, 0.006200000000000001, 0.0097, 7.0E-4, 0.001, 4.000000000000001E-4, 3.0000000000000003E-4, 0.0, 0.0, 0.0, 0.0, 2.0E-4, 5.0E-4, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
    //Board5    Board4    Value
    //other     other     0.20364
    //other     suit3     0.0
    //other     suit4     0.0
    //other     rainbow   0.5121
    //other     straight3 0.0
    //other     straight4 0.0
    //other     sf3       0.0
    //other     triple    0.0
    //other     pair      0.0
    //other     twopair   0.0
    //suit3     other     0.25112
    //suit3     suit3     0.61032
    //suit3     suit4     0.0
    //suit3     rainbow   0.0
    //suit3     straight3 0.03349
    //suit3     straight4 0.0
    //suit3     sf3       0.07751
    //suit3     triple    0.0
    //suit3     pair      0.26336
    //suit3     twopair   0.45388
    //suit4     other     0.03378
    //suit4     suit3     0.15436
    //suit4     suit4     0.7367400000000001
    //suit4     rainbow   0.0
    //suit4     straight3 0.00461
    //suit4     straight4 0.0
    //suit4     sf3       0.0208
    //suit4     triple    0.0
    //suit4     pair      0.02417
    //suit4     twopair   0.0
    //rainbow   other     0.0
    //rainbow   suit3     0.0
    //rainbow   suit4     0.0
    //rainbow   rainbow   0.0
    //rainbow   straight3 0.0
    //rainbow   straight4 0.0
    //rainbow   sf3       0.0
    //rainbow   triple    0.0
    //rainbow   pair      0.0
    //rainbow   twopair   0.0
    //straight3 other     0.15983
    //straight3 suit3     0.14488
    //straight3 suit4     0.08468000000000002
    //straight3 rainbow   0.21472
    //straight3 straight3 0.60972
    //straight3 straight4 0.09773
    //straight3 sf3       0.0
    //straight3 triple    0.0
    //straight3 pair      0.07651
    //straight3 twopair   0.00559
    //straight4 other     0.03114
    //straight4 suit3     0.02633
    //straight4 suit4     0.013330000000000002
    //straight4 rainbow   0.04799
    //straight4 straight3 0.19683
    //straight4 straight4 0.76616
    //straight4 sf3       0.0
    //straight4 triple    0.0
    //straight4 pair      0.0052
    //straight4 twopair   0.0
    //sf3       other     0.01734
    //sf3       suit3     0.05421
    //sf3       suit4     0.16525000000000004
    //sf3       rainbow   0.0
    //sf3       straight3 0.08417
    //sf3       straight4 0.13611
    //sf3       sf3       0.89906
    //sf3       triple    0.0041
    //sf3       pair      0.01092
    //sf3       twopair   0.00593
    //triple    other     0.02252
    //triple    suit3     0.0099
    //triple    suit4     0.0
    //triple    rainbow   0.0
    //triple    straight3 0.00793
    //triple    straight4 0.0
    //triple    sf3       0.00263
    //triple    triple    0.9959
    //triple    pair      0.0418
    //triple    twopair   0.08368
    //pair      other     0.24626
    //pair      suit3     0.0
    //pair      suit4     0.0
    //pair      rainbow   0.22519
    //pair      straight3 0.05264
    //pair      straight4 0.0
    //pair      sf3       0.0
    //pair      triple    0.0
    //pair      pair      0.4857
    //pair      twopair   0.0
    //twopair   other     0.03437
    //twopair   suit3     0.0
    //twopair   suit4     0.0
    //twopair   rainbow   0.0
    //twopair   straight3 0.01061
    //twopair   straight4 0.0
    //twopair   sf3       0.0
    //twopair   triple    0.0
    //twopair   pair      0.09234
    //twopair   twopair   0.45092
    double[] cpt06 = new double[]{ 0.20364, 0.0, 0.0, 0.5121, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.25112, 0.61032, 0.0, 0.0, 0.03349, 0.0, 0.07751, 0.0, 0.26336, 0.45388, 0.03378, 0.15436, 0.7367400000000001, 0.0, 0.00461, 0.0, 0.0208, 0.0, 0.02417, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.15983, 0.14488, 0.08468000000000002, 0.21472, 0.60972, 0.09773, 0.0, 0.0, 0.07651, 0.00559, 0.03114, 0.02633, 0.013330000000000002, 0.04799, 0.19683, 0.76616, 0.0, 0.0, 0.0052, 0.0, 0.01734, 0.05421, 0.16525000000000004, 0.0, 0.08417, 0.13611, 0.89906, 0.0041, 0.01092, 0.00593, 0.02252, 0.0099, 0.0, 0.0, 0.00793, 0.0, 0.00263, 0.9959, 0.0418, 0.08368, 0.24626, 0.0, 0.0, 0.22519, 0.05264, 0.0, 0.0, 0.0, 0.4857, 0.0, 0.03437, 0.0, 0.0, 0.0, 0.01061, 0.0, 0.0, 0.0, 0.09234, 0.45092 };
    //OppBet3  OppHand3      Value
    //check    nothing       0.34
    //check    pair          0.2
    //check    twopair       0.05
    //check    triple        0.025
    //check    straight      0.025
    //check    flush         0.05
    //check    fullhouse     0.1
    //check    quad          0.2
    //check    straightflush 0.2
    //call     nothing       0.34
    //call     pair          0.2
    //call     twopair       0.05
    //call     triple        0.025
    //call     straight      0.025
    //call     flush         0.05
    //call     fullhouse     0.1
    //call     quad          0.2
    //call     straightflush 0.2
    //small    nothing       0.2
    //small    pair          0.45
    //small    twopair       0.3
    //small    triple        0.2
    //small    straight      0.15
    //small    flush         0.2
    //small    fullhouse     0.2
    //small    quad          0.2
    //small    straightflush 0.2
    //moderate nothing       0.1
    //moderate pair          0.1
    //moderate twopair       0.5
    //moderate triple        0.5
    //moderate straight      0.55
    //moderate flush         0.5
    //moderate fullhouse     0.25
    //moderate quad          0.2
    //moderate straightflush 0.2
    //large    nothing       0.02
    //large    pair          0.05
    //large    twopair       0.1
    //large    triple        0.25
    //large    straight      0.25
    //large    flush         0.2
    //large    fullhouse     0.35
    //large    quad          0.2
    //large    straightflush 0.2
    double[] cpt07 = new double[]{ 0.34, 0.2, 0.05, 0.025, 0.025, 0.05, 0.1, 0.2, 0.2, 0.34, 0.2, 0.05, 0.025, 0.025, 0.05, 0.1, 0.2, 0.2, 0.2, 0.45, 0.3, 0.2, 0.15, 0.2, 0.2, 0.2, 0.2, 0.1, 0.1, 0.5, 0.5, 0.55, 0.5, 0.25, 0.2, 0.2, 0.02, 0.05, 0.1, 0.25, 0.25, 0.2, 0.35, 0.2, 0.2 };
    //OppBet4  OppHand4      Value
    //check    nothing       0.46
    //check    pair          0.3
    //check    twopair       0.1
    //check    triple        0.025
    //check    straight      0.025
    //check    flush         0.025
    //check    fullhouse     0.05
    //check    quad          0.05
    //check    straightflush 0.05
    //call     nothing       0.46
    //call     pair          0.3
    //call     twopair       0.1
    //call     triple        0.025
    //call     straight      0.025
    //call     flush         0.025
    //call     fullhouse     0.05
    //call     quad          0.05
    //call     straightflush 0.05
    //small    nothing       0.06
    //small    pair          0.25
    //small    twopair       0.3
    //small    triple        0.2
    //small    straight      0.15
    //small    flush         0.1
    //small    fullhouse     0.2
    //small    quad          0.1
    //small    straightflush 0.2
    //moderate nothing       0.01
    //moderate pair          0.1
    //moderate twopair       0.4
    //moderate triple        0.55
    //moderate straight      0.55
    //moderate flush         0.6
    //moderate fullhouse     0.45
    //moderate quad          0.55
    //moderate straightflush 0.3
    //large    nothing       0.01
    //large    pair          0.05
    //large    twopair       0.1
    //large    triple        0.2
    //large    straight      0.25
    //large    flush         0.25
    //large    fullhouse     0.25
    //large    quad          0.25
    //large    straightflush 0.4
    double[] cpt08 = new double[]{ 0.46, 0.3, 0.1, 0.025, 0.025, 0.025, 0.05, 0.05, 0.05, 0.46, 0.3, 0.1, 0.025, 0.025, 0.025, 0.05, 0.05, 0.05, 0.06, 0.25, 0.3, 0.2, 0.15, 0.1, 0.2, 0.1, 0.2, 0.01, 0.1, 0.4, 0.55, 0.55, 0.6, 0.45, 0.55, 0.3, 0.01, 0.05, 0.1, 0.2, 0.25, 0.25, 0.25, 0.25, 0.4 };
    //OppHand5      Board5    OppDealtCards Value
    //nothing       other     samesuit      0.1772
    //nothing       other     connected     0.1789
    //nothing       other     pair          0.0
    //nothing       other     other         0.1817
    //nothing       suit3     samesuit      0.16040000000000001
    //nothing       suit3     connected     0.18610000000000002
    //nothing       suit3     pair          0.0
    //nothing       suit3     other         0.1865
    //nothing       suit4     samesuit      0.2013
    //nothing       suit4     connected     0.1365
    //nothing       suit4     pair          0.0
    //nothing       suit4     other         0.14470000000000002
    //nothing       rainbow   samesuit      0.3951
    //nothing       rainbow   connected     0.37400000000000005
    //nothing       rainbow   pair          0.0
    //nothing       rainbow   other         0.3549
    //nothing       straight3 samesuit      0.1663
    //nothing       straight3 connected     0.2017
    //nothing       straight3 pair          9.999999999999999E-5
    //nothing       straight3 other         0.1829
    //nothing       straight4 samesuit      0.1275
    //nothing       straight4 connected     0.2292
    //nothing       straight4 pair          0.0
    //nothing       straight4 other         0.1352
    //nothing       sf3       samesuit      0.1822
    //nothing       sf3       connected     0.17570000000000002
    //nothing       sf3       pair          0.0
    //nothing       sf3       other         0.17240000000000003
    //nothing       triple    samesuit      0.0
    //nothing       triple    connected     0.0
    //nothing       triple    pair          0.0
    //nothing       triple    other         0.0
    //nothing       pair      samesuit      0.0
    //nothing       pair      connected     0.0
    //nothing       pair      pair          0.0
    //nothing       pair      other         0.0
    //nothing       twopair   samesuit      0.0
    //nothing       twopair   connected     0.0
    //nothing       twopair   pair          0.0
    //nothing       twopair   other         0.0
    //pair          other     samesuit      0.4355
    //pair          other     connected     0.4472999999999999
    //pair          other     pair          0.36350000000000005
    //pair          other     other         0.4489
    //pair          suit3     samesuit      0.39590000000000003
    //pair          suit3     connected     0.44730000000000003
    //pair          suit3     pair          0.3944
    //pair          suit3     other         0.4514
    //pair          suit4     samesuit      0.4114
    //pair          suit4     connected     0.3234
    //pair          suit4     pair          0.259
    //pair          suit4     other         0.3173000000000001
    //pair          rainbow   samesuit      0.4671
    //pair          rainbow   connected     0.45690000000000003
    //pair          rainbow   pair          0.7498
    //pair          rainbow   other         0.4921
    //pair          straight3 samesuit      0.417
    //pair          straight3 connected     0.3822
    //pair          straight3 pair          0.3958999999999999
    //pair          straight3 other         0.42139999999999994
    //pair          straight4 samesuit      0.3872
    //pair          straight4 connected     0.3081
    //pair          straight4 pair          0.3417
    //pair          straight4 other         0.4037
    //pair          sf3       samesuit      0.4376
    //pair          sf3       connected     0.44630000000000003
    //pair          sf3       pair          0.3634
    //pair          sf3       other         0.45450000000000007
    //pair          triple    samesuit      0.0
    //pair          triple    connected     0.0
    //pair          triple    pair          0.0
    //pair          triple    other         0.0
    //pair          pair      samesuit      0.5149
    //pair          pair      connected     0.5306
    //pair          pair      pair          0.0
    //pair          pair      other         0.5063
    //pair          twopair   samesuit      0.0
    //pair          twopair   connected     0.0
    //pair          twopair   pair          0.0
    //pair          twopair   other         0.0
    //twopair       other     samesuit      0.22
    //twopair       other     connected     0.21889999999999998
    //twopair       other     pair          0.39760000000000006
    //twopair       other     other         0.2313
    //twopair       suit3     samesuit      0.18810000000000002
    //twopair       suit3     connected     0.21580000000000002
    //twopair       suit3     pair          0.3901
    //twopair       suit3     other         0.2244
    //twopair       suit4     samesuit      0.1783
    //twopair       suit4     connected     0.1376
    //twopair       suit4     pair          0.1237
    //twopair       suit4     other         0.13710000000000003
    //twopair       rainbow   samesuit      0.0783
    //twopair       rainbow   connected     0.08700000000000001
    //twopair       rainbow   pair          0.0
    //twopair       rainbow   other         0.0821
    //twopair       straight3 samesuit      0.1903
    //twopair       straight3 connected     0.19
    //twopair       straight3 pair          0.32110000000000005
    //twopair       straight3 other         0.19989999999999997
    //twopair       straight4 samesuit      0.1519
    //twopair       straight4 connected     0.1875
    //twopair       straight4 pair          0.1961
    //twopair       straight4 other         0.1523
    //twopair       sf3       samesuit      0.2195
    //twopair       sf3       connected     0.23410000000000003
    //twopair       sf3       pair          0.3936
    //twopair       sf3       other         0.22700000000000004
    //twopair       triple    samesuit      0.0
    //twopair       triple    connected     0.0
    //twopair       triple    pair          0.0
    //twopair       triple    other         0.0
    //twopair       pair      samesuit      0.33
    //twopair       pair      connected     0.3406
    //twopair       pair      pair          0.8270000000000001
    //twopair       pair      other         0.3636
    //twopair       twopair   samesuit      0.734
    //twopair       twopair   connected     0.8014
    //twopair       twopair   pair          0.9229
    //twopair       twopair   other         0.8094
    //triple        other     samesuit      0.0466
    //triple        other     connected     0.0453
    //triple        other     pair          0.11990000000000002
    //triple        other     other         0.05
    //triple        suit3     samesuit      0.033600000000000005
    //triple        suit3     connected     0.034600000000000006
    //triple        suit3     pair          0.1326
    //triple        suit3     other         0.0436
    //triple        suit4     samesuit      0.0223
    //triple        suit4     connected     0.0161
    //triple        suit4     pair          0.1429
    //triple        suit4     other         0.023500000000000007
    //triple        rainbow   samesuit      0.0
    //triple        rainbow   connected     0.0
    //triple        rainbow   pair          0.2347
    //triple        rainbow   other         0.0146
    //triple        straight3 samesuit      0.0328
    //triple        straight3 connected     0.0203
    //triple        straight3 pair          0.13450000000000004
    //triple        straight3 other         0.0381
    //triple        straight4 samesuit      0.0187
    //triple        straight4 connected     0.0073
    //triple        straight4 pair          0.1716
    //triple        straight4 other         0.0284
    //triple        sf3       samesuit      0.0437
    //triple        sf3       connected     0.042300000000000004
    //triple        sf3       pair          0.1214
    //triple        sf3       other         0.05450000000000001
    //triple        triple    samesuit      0.6761
    //triple        triple    connected     0.6957
    //triple        triple    pair          0.0926
    //triple        triple    other         0.6577
    //triple        pair      samesuit      0.0651
    //triple        pair      connected     0.0655
    //triple        pair      pair          0.0
    //triple        pair      other         0.0694
    //triple        twopair   samesuit      0.0077
    //triple        twopair   connected     0.0036
    //triple        twopair   pair          0.0
    //triple        twopair   other         0.0026
    //straight      other     samesuit      0.0295
    //straight      other     connected     0.052099999999999994
    //straight      other     pair          0.007500000000000001
    //straight      other     other         0.033
    //straight      suit3     samesuit      0.028700000000000003
    //straight      suit3     connected     0.052300000000000006
    //straight      suit3     pair          0.0076
    //straight      suit3     other         0.0332
    //straight      suit4     samesuit      0.0337
    //straight      suit4     connected     0.0361
    //straight      suit4     pair          0.0052
    //straight      suit4     other         0.026500000000000006
    //straight      rainbow   samesuit      0.0589
    //straight      rainbow   connected     0.08160000000000002
    //straight      rainbow   pair          0.0152
    //straight      rainbow   other         0.0557
    //straight      straight3 samesuit      0.0974
    //straight      straight3 connected     0.1367
    //straight      straight3 pair          0.05059999999999999
    //straight      straight3 other         0.09989999999999999
    //straight      straight4 samesuit      0.2262
    //straight      straight4 connected     0.2042
    //straight      straight4 pair          0.2148
    //straight      straight4 other         0.2246
    //straight      sf3       samesuit      0.0301
    //straight      sf3       connected     0.043500000000000004
    //straight      sf3       pair          0.0073
    //straight      sf3       other         0.03330000000000001
    //straight      triple    samesuit      0.0021
    //straight      triple    connected     0.0058
    //straight      triple    pair          0.0
    //straight      triple    other         0.0024
    //straight      pair      samesuit      0.0108
    //straight      pair      connected     0.0227
    //straight      pair      pair          4.000000000000001E-4
    //straight      pair      other         0.0102
    //straight      twopair   samesuit      6.0E-4
    //straight      twopair   connected     0.0018
    //straight      twopair   pair          0.0
    //straight      twopair   other         3.0E-4
    //flush         other     samesuit      0.065
    //flush         other     connected     0.0315
    //flush         other     pair          0.020000000000000004
    //flush         other     other         0.028
    //flush         suit3     samesuit      0.17410000000000003
    //flush         suit3     connected     0.043300000000000005
    //flush         suit3     pair          0.0
    //flush         suit3     other         0.0387
    //flush         suit4     samesuit      0.1385
    //flush         suit4     connected     0.3363
    //flush         suit4     pair          0.4155
    //flush         suit4     other         0.33810000000000007
    //flush         rainbow   samesuit      0.0
    //flush         rainbow   connected     0.0
    //flush         rainbow   pair          0.0
    //flush         rainbow   other         0.0
    //flush         straight3 samesuit      0.0756
    //flush         straight3 connected     0.039
    //flush         straight3 pair          0.026499999999999996
    //flush         straight3 other         0.0389
    //flush         straight4 samesuit      0.0736
    //flush         straight4 connected     0.037
    //flush         straight4 pair          0.0239
    //flush         straight4 other         0.0378
    //flush         sf3       samesuit      0.0629
    //flush         sf3       connected     0.03330000000000001
    //flush         sf3       pair          0.0198
    //flush         sf3       other         0.030200000000000005
    //flush         triple    samesuit      0.0338
    //flush         triple    connected     0.0079
    //flush         triple    pair          0.0
    //flush         triple    other         0.0086
    //flush         pair      samesuit      0.0624
    //flush         pair      connected     0.0234
    //flush         pair      pair          0.013900000000000001
    //flush         pair      other         0.0247
    //flush         twopair   samesuit      0.0836
    //flush         twopair   connected     0.0224
    //flush         twopair   pair          0.0
    //flush         twopair   other         0.0233
    //fullhouse     other     samesuit      0.0239
    //fullhouse     other     connected     0.0221
    //fullhouse     other     pair          0.08190000000000001
    //fullhouse     other     other         0.0243
    //fullhouse     suit3     samesuit      0.016800000000000002
    //fullhouse     suit3     connected     0.017500000000000005
    //fullhouse     suit3     pair          0.0675
    //fullhouse     suit3     other         0.0201
    //fullhouse     suit4     samesuit      0.0073
    //fullhouse     suit4     connected     0.0058
    //fullhouse     suit4     pair          0.0433
    //fullhouse     suit4     other         0.008200000000000002
    //fullhouse     rainbow   samesuit      0.0
    //fullhouse     rainbow   connected     0.0
    //fullhouse     rainbow   pair          0.0
    //fullhouse     rainbow   other         0.0
    //fullhouse     straight3 samesuit      0.0147
    //fullhouse     straight3 connected     0.023
    //fullhouse     straight3 pair          0.05929999999999999
    //fullhouse     straight3 other         0.0157
    //fullhouse     straight4 samesuit      0.0057
    //fullhouse     straight4 connected     0.0157
    //fullhouse     straight4 pair          0.0377
    //fullhouse     straight4 other         0.0079
    //fullhouse     sf3       samesuit      0.021
    //fullhouse     sf3       connected     0.022400000000000003
    //fullhouse     sf3       pair          0.0857
    //fullhouse     sf3       other         0.025400000000000002
    //fullhouse     triple    samesuit      0.2404999999999999
    //fullhouse     triple    connected     0.24
    //fullhouse     triple    pair          0.9074
    //fullhouse     triple    other         0.2861
    //fullhouse     pair      samesuit      0.0158
    //fullhouse     pair      connected     0.0163
    //fullhouse     pair      pair          0.14390000000000003
    //fullhouse     pair      other         0.0242
    //fullhouse     twopair   samesuit      0.1734
    //fullhouse     twopair   connected     0.1701
    //fullhouse     twopair   pair          0.0482
    //fullhouse     twopair   other         0.1622
    //quad          other     samesuit      0.0011
    //quad          other     connected     0.0014999999999999998
    //quad          other     pair          0.009200000000000002
    //quad          other     other         0.002
    //quad          suit3     samesuit      9.000000000000001E-4
    //quad          suit3     connected     5.000000000000001E-4
    //quad          suit3     pair          0.0073
    //quad          suit3     other         0.001
    //quad          suit4     samesuit      0.0
    //quad          suit4     connected     0.0
    //quad          suit4     pair          0.0057
    //quad          suit4     other         4.0000000000000013E-4
    //quad          rainbow   samesuit      0.0
    //quad          rainbow   connected     0.0
    //quad          rainbow   pair          0.0
    //quad          rainbow   other         0.0
    //quad          straight3 samesuit      5.0E-4
    //quad          straight3 connected     6.0E-4
    //quad          straight3 pair          0.009900000000000003
    //quad          straight3 other         7.999999999999999E-4
    //quad          straight4 samesuit      0.0
    //quad          straight4 connected     0.0
    //quad          straight4 pair          0.0061
    //quad          straight4 other         7.0E-4
    //quad          sf3       samesuit      0.0011
    //quad          sf3       connected     0.0011000000000000003
    //quad          sf3       pair          0.0081
    //quad          sf3       other         0.0014000000000000002
    //quad          triple    samesuit      0.04719999999999998
    //quad          triple    connected     0.0502
    //quad          triple    pair          0.0
    //quad          triple    other         0.0449
    //quad          pair      samesuit      0.0
    //quad          pair      connected     0.0
    //quad          pair      pair          0.014500000000000002
    //quad          pair      other         7.0E-4
    //quad          twopair   samesuit      0.0
    //quad          twopair   connected     0.0
    //quad          twopair   pair          0.0289
    //quad          twopair   other         0.0016
    //straightflush other     samesuit      0.0012
    //straightflush other     connected     0.0024
    //straightflush other     pair          4.000000000000001E-4
    //straightflush other     other         8.0E-4
    //straightflush suit3     samesuit      0.0015000000000000002
    //straightflush suit3     connected     0.0026000000000000003
    //straightflush suit3     pair          5.0E-4
    //straightflush suit3     other         0.0011
    //straightflush suit4     samesuit      0.0072
    //straightflush suit4     connected     0.0082
    //straightflush suit4     pair          0.0047
    //straightflush suit4     other         0.004200000000000001
    //straightflush rainbow   samesuit      6.0E-4
    //straightflush rainbow   connected     5.000000000000001E-4
    //straightflush rainbow   pair          3.0E-4
    //straightflush rainbow   other         6.0E-4
    //straightflush straight3 samesuit      0.0054
    //straightflush straight3 connected     0.0065
    //straightflush straight3 pair          0.0021000000000000003
    //straightflush straight3 other         0.0024
    //straightflush straight4 samesuit      0.0092
    //straightflush straight4 connected     0.011
    //straightflush straight4 pair          0.0081
    //straightflush straight4 other         0.0094
    //straightflush sf3       samesuit      0.0019
    //straightflush sf3       connected     0.0013000000000000002
    //straightflush sf3       pair          7.0E-4
    //straightflush sf3       other         0.0013000000000000002
    //straightflush triple    samesuit      3.0E-4
    //straightflush triple    connected     4.0E-4
    //straightflush triple    pair          0.0
    //straightflush triple    other         3.0E-4
    //straightflush pair      samesuit      0.001
    //straightflush pair      connected     9.0E-4
    //straightflush pair      pair          3.0000000000000003E-4
    //straightflush pair      other         9.0E-4
    //straightflush twopair   samesuit      7.0E-4
    //straightflush twopair   connected     7.0E-4
    //straightflush twopair   pair          0.0
    //straightflush twopair   other         6.0E-4
    double[] cpt09 = new double[]{ 0.1772, 0.1789, 0.0, 0.1817, 0.16040000000000001, 0.18610000000000002, 0.0, 0.1865, 0.2013, 0.1365, 0.0, 0.14470000000000002, 0.3951, 0.37400000000000005, 0.0, 0.3549, 0.1663, 0.2017, 9.999999999999999E-5, 0.1829, 0.1275, 0.2292, 0.0, 0.1352, 0.1822, 0.17570000000000002, 0.0, 0.17240000000000003, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.4355, 0.4472999999999999, 0.36350000000000005, 0.4489, 0.39590000000000003, 0.44730000000000003, 0.3944, 0.4514, 0.4114, 0.3234, 0.259, 0.3173000000000001, 0.4671, 0.45690000000000003, 0.7498, 0.4921, 0.417, 0.3822, 0.3958999999999999, 0.42139999999999994, 0.3872, 0.3081, 0.3417, 0.4037, 0.4376, 0.44630000000000003, 0.3634, 0.45450000000000007, 0.0, 0.0, 0.0, 0.0, 0.5149, 0.5306, 0.0, 0.5063, 0.0, 0.0, 0.0, 0.0, 0.22, 0.21889999999999998, 0.39760000000000006, 0.2313, 0.18810000000000002, 0.21580000000000002, 0.3901, 0.2244, 0.1783, 0.1376, 0.1237, 0.13710000000000003, 0.0783, 0.08700000000000001, 0.0, 0.0821, 0.1903, 0.19, 0.32110000000000005, 0.19989999999999997, 0.1519, 0.1875, 0.1961, 0.1523, 0.2195, 0.23410000000000003, 0.3936, 0.22700000000000004, 0.0, 0.0, 0.0, 0.0, 0.33, 0.3406, 0.8270000000000001, 0.3636, 0.734, 0.8014, 0.9229, 0.8094, 0.0466, 0.0453, 0.11990000000000002, 0.05, 0.033600000000000005, 0.034600000000000006, 0.1326, 0.0436, 0.0223, 0.0161, 0.1429, 0.023500000000000007, 0.0, 0.0, 0.2347, 0.0146, 0.0328, 0.0203, 0.13450000000000004, 0.0381, 0.0187, 0.0073, 0.1716, 0.0284, 0.0437, 0.042300000000000004, 0.1214, 0.05450000000000001, 0.6761, 0.6957, 0.0926, 0.6577, 0.0651, 0.0655, 0.0, 0.0694, 0.0077, 0.0036, 0.0, 0.0026, 0.0295, 0.052099999999999994, 0.007500000000000001, 0.033, 0.028700000000000003, 0.052300000000000006, 0.0076, 0.0332, 0.0337, 0.0361, 0.0052, 0.026500000000000006, 0.0589, 0.08160000000000002, 0.0152, 0.0557, 0.0974, 0.1367, 0.05059999999999999, 0.09989999999999999, 0.2262, 0.2042, 0.2148, 0.2246, 0.0301, 0.043500000000000004, 0.0073, 0.03330000000000001, 0.0021, 0.0058, 0.0, 0.0024, 0.0108, 0.0227, 4.000000000000001E-4, 0.0102, 6.0E-4, 0.0018, 0.0, 3.0E-4, 0.065, 0.0315, 0.020000000000000004, 0.028, 0.17410000000000003, 0.043300000000000005, 0.0, 0.0387, 0.1385, 0.3363, 0.4155, 0.33810000000000007, 0.0, 0.0, 0.0, 0.0, 0.0756, 0.039, 0.026499999999999996, 0.0389, 0.0736, 0.037, 0.0239, 0.0378, 0.0629, 0.03330000000000001, 0.0198, 0.030200000000000005, 0.0338, 0.0079, 0.0, 0.0086, 0.0624, 0.0234, 0.013900000000000001, 0.0247, 0.0836, 0.0224, 0.0, 0.0233, 0.0239, 0.0221, 0.08190000000000001, 0.0243, 0.016800000000000002, 0.017500000000000005, 0.0675, 0.0201, 0.0073, 0.0058, 0.0433, 0.008200000000000002, 0.0, 0.0, 0.0, 0.0, 0.0147, 0.023, 0.05929999999999999, 0.0157, 0.0057, 0.0157, 0.0377, 0.0079, 0.021, 0.022400000000000003, 0.0857, 0.025400000000000002, 0.2404999999999999, 0.24, 0.9074, 0.2861, 0.0158, 0.0163, 0.14390000000000003, 0.0242, 0.1734, 0.1701, 0.0482, 0.1622, 0.0011, 0.0014999999999999998, 0.009200000000000002, 0.002, 9.000000000000001E-4, 5.000000000000001E-4, 0.0073, 0.001, 0.0, 0.0, 0.0057, 4.0000000000000013E-4, 0.0, 0.0, 0.0, 0.0, 5.0E-4, 6.0E-4, 0.009900000000000003, 7.999999999999999E-4, 0.0, 0.0, 0.0061, 7.0E-4, 0.0011, 0.0011000000000000003, 0.0081, 0.0014000000000000002, 0.04719999999999998, 0.0502, 0.0, 0.0449, 0.0, 0.0, 0.014500000000000002, 7.0E-4, 0.0, 0.0, 0.0289, 0.0016, 0.0012, 0.0024, 4.000000000000001E-4, 8.0E-4, 0.0015000000000000002, 0.0026000000000000003, 5.0E-4, 0.0011, 0.0072, 0.0082, 0.0047, 0.004200000000000001, 6.0E-4, 5.000000000000001E-4, 3.0E-4, 6.0E-4, 0.0054, 0.0065, 0.0021000000000000003, 0.0024, 0.0092, 0.011, 0.0081, 0.0094, 0.0019, 0.0013000000000000002, 7.0E-4, 0.0013000000000000002, 3.0E-4, 4.0E-4, 0.0, 3.0E-4, 0.001, 9.0E-4, 3.0000000000000003E-4, 9.0E-4, 7.0E-4, 7.0E-4, 0.0, 6.0E-4 };
    //OppBet5  OppHand5      Value
    //check    nothing       0.6
    //check    pair          0.4
    //check    twopair       0.1
    //check    triple        0.025
    //check    straight      0.025
    //check    flush         0.05
    //check    fullhouse     0.1
    //check    quad          0.2
    //check    straightflush 0.2
    //call     nothing       0.19999999999999998
    //call     pair          0.4
    //call     twopair       0.1
    //call     triple        0.025
    //call     straight      0.025
    //call     flush         0.05
    //call     fullhouse     0.1
    //call     quad          0.2
    //call     straightflush 0.2
    //small    nothing       0.049999999999999996
    //small    pair          0.1
    //small    twopair       0.3
    //small    triple        0.2
    //small    straight      0.15
    //small    flush         0.2
    //small    fullhouse     0.2
    //small    quad          0.2
    //small    straightflush 0.2
    //moderate nothing       0.049999999999999996
    //moderate pair          0.09
    //moderate twopair       0.4
    //moderate triple        0.5
    //moderate straight      0.55
    //moderate flush         0.5
    //moderate fullhouse     0.25
    //moderate quad          0.2
    //moderate straightflush 0.2
    //large    nothing       0.09999999999999999
    //large    pair          0.01
    //large    twopair       0.1
    //large    triple        0.25
    //large    straight      0.25
    //large    flush         0.2
    //large    fullhouse     0.35
    //large    quad          0.2
    //large    straightflush 0.2
    double[] cpt10 = new double[]{ 0.6, 0.4, 0.1, 0.025, 0.025, 0.05, 0.1, 0.2, 0.2, 0.19999999999999998, 0.4, 0.1, 0.025, 0.025, 0.05, 0.1, 0.2, 0.2, 0.049999999999999996, 0.1, 0.3, 0.2, 0.15, 0.2, 0.2, 0.2, 0.2, 0.049999999999999996, 0.09, 0.4, 0.5, 0.55, 0.5, 0.25, 0.2, 0.2, 0.09999999999999999, 0.01, 0.1, 0.25, 0.25, 0.2, 0.35, 0.2, 0.2 };

    /*
      Create a IL2 Table for each cpt.
      The parameters to the Table constructor are:
      (1) the domain,
      (2) the variable ids that name the dimensions of the table (in the form of an IntSet),
      (3) the cpt data.
    */
    Table table00 = new Table( domain, new IntSet( new int[]{ id00 } ), cpt00 );
    Table table01 = new Table( domain, new IntSet( new int[]{ id01 } ), cpt01 );
    Table table02 = new Table( domain, new IntSet( new int[]{ id00, id02 } ), cpt02 );
    Table table03 = new Table( domain, new IntSet( new int[]{ id01, id03 } ), cpt03 );
    Table table04 = new Table( domain, new IntSet( new int[]{ id00, id01, id04 } ), cpt04 );
    Table table05 = new Table( domain, new IntSet( new int[]{ id01, id02, id05 } ), cpt05 );
    Table table06 = new Table( domain, new IntSet( new int[]{ id02, id06 } ), cpt06 );
    Table table07 = new Table( domain, new IntSet( new int[]{ id04, id07 } ), cpt07 );
    Table table08 = new Table( domain, new IntSet( new int[]{ id05, id08 } ), cpt08 );
    Table table09 = new Table( domain, new IntSet( new int[]{ id01, id06, id09 } ), cpt09 );
    Table table10 = new Table( domain, new IntSet( new int[]{ id09, id10 } ), cpt10 );

    /* Create an array of all the Tables. */
    Table[] tables = new Table[]{ table00, table01, table02, table03, table04, table05, table06, table07, table08, table09, table10 }; 

    /*
      The simple BayesianNetwork constructor takes only one argument:
      an array of Tables.
    */
    BayesianNetwork model = new BayesianNetwork( tables );
    return model;
  }
}
