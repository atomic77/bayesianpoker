######################################################
# Alex Tomic
# Uncertain Reasoning / Data Mining
# Dec 2, 2010
# Functions used for doing monte carlo simulation of
# poker hands and simulations
######################################################

MAX_TRIES= 20;
BOARDS = c("other","suit3","suit4","rainbow","straight3","straight4","sf3","triple","pair","twopair");
HANDS = c("nothing","pair","twopair","triple","straight","flush","fullhouse","quad","straightflush");
DEALT = c("samesuit","connected","pair","other");

samplefreq = function(n, handsize = 7) {
  sfreq = vector(length=9); 
  for (i in 1:9) { sfreq[i] = 0; }
  names(sfreq) = c("nothing","pair","twopair","triple","straight","flush","fullhouse","quad","straightflush");
  starttime = proc.time();
  for (i in 1:n) {
    res = evaluatehand(sample(52,handsize));
    sfreq[res] = sfreq[res] + 1;
  }
  endtime = proc.time();
  elapsed = endtime[3] - starttime[3];
  srate = n / elapsed;
  print( paste("Time: ", elapsed, "Rate/s: ", srate)  , quote = FALSE);
  return(sfreq);
}

samplecondfreq = function(n, handsize=3, board, dealt, debug=FALSE) {
  sfreq = vector(length=9); 
  for (i in 1:9) { sfreq[i] = 0; }
  names(sfreq) = HANDS;
  starttime = proc.time();
  for (i in 1:n) {
    d = generaterandompocket(2,dealt);
    brd = generaterandomboard(handsize, board);
    # Unfortunately we need to do a hackish way of avoiding that we have
    # overlap between the dealt cards and board -- we'll do a set diff
    # and reject any hand that has overlap; this is much easier
    # than having to build in the ability to sample from a specific set of cards
    tries = 0;
    while(length(intersect(brd,d)) > 0 && tries < MAX_TRIES) {
      brd = generaterandomboard(handsize, board);
    }
    if (tries < MAX_TRIES) {
      hand = c(d,brd);
      res = evaluatehand(hand);
      sfreq[res] = sfreq[res] + 1;
    }
  }
 
  endtime = proc.time();
  elapsed = endtime[3] - starttime[3];
  srate = n / elapsed;
  if (debug) { print( paste("Time: ", elapsed, "Rate/s: ", srate)  , quote = FALSE); }
  return(sfreq);
  
}

sampleallcondfreq = function(n, handsize=3, fileout, debug=FALSE) {
#   allresults = vector(length=(length(BOARDS)*length(DEALT)));
  allresults = matrix(ncol=length(HANDS));
  iter = 1;
  cat("(",file=fileout,append=T);
  for (b in BOARDS) {
    cat("(",file=fileout,append=T);
    for (d in DEALT) {
      if (debug) { print(paste("Processing ",b, ", ", d)); }
      res = samplecondfreq(n,handsize,b,d,debug);
      cat("(",file=fileout,append=T);
      write(res,fileout,sep = "\t", ncolumns = 9, append=TRUE);
      cat(")\n",file=fileout,append=T);
      iter = iter+1;
#       allresults = rbind(allresults,res);
      if (debug) { print(res);}
    }
   
    cat(")\n",file=fileout,append=T);
  }

  cat(")\n",file=fileout,append=T);
#   return(allresults);
}

sampleallboardcondfreq = function(n, boardsize=3, fileout, debug=FALSE) {
#   allresults = vector(length=(length(BOARDS)*length(DEALT)));
  allresults = matrix(ncol=length(HANDS));
  iter = 1;
  cat("(",file=fileout,append=T);
  for (b in BOARDS) {
      if (debug) { print(paste("Processing ",b)); }
      res = sampleboardcondfreq(n, boardsize,b,debug);
      cat("(",file=fileout,append=T);
      write(res,fileout,sep = "\t", ncolumns = 9, append=TRUE);
      cat(")\n",file=fileout,append=T);
      iter = iter+1;
#       allresults = rbind(allresults,res);
      if (debug) { print(res);}
   
    cat(")\n",file=fileout,append=T);
  }

  cat(")\n",file=fileout,append=T);
#   return(allresults);
}

sampleboardfreq = function(n, boardsize = 3) {
  sfreq = vector(length=(length(BOARDS))); 
  names(sfreq) = BOARDS;
  
  for (i in 1:(length(BOARDS))) { sfreq[i] = 0; }
  starttime = proc.time();
  for (i in 1:n) {
    res = evaluateboard(sample(52,boardsize));
    sfreq[res] = sfreq[res] + 1;
  }
  endtime = proc.time();
  elapsed = endtime[3] - starttime[3];
  srate = n / elapsed;
  print( paste("Time: ", elapsed, "Rate/s: ", srate)  , quote = FALSE);
  return(sfreq);
}

sampleboardcondfreq = function(n, condboardsize=3, board, debug=FALSE) {
  sfreq = vector(length=(length(BOARDS))); 
  names(sfreq) = BOARDS;
  for (i in 1:(length(BOARDS))) { sfreq[i] = 0; }
  starttime = proc.time();
  for (i in 1:n) {
    brd = generaterandomboard(condboardsize, board);
		#print(brd);
    # We've generated a board, now draw another card and see what we
    # create
    cards.rem = setdiff(1:52,brd);
    nextcard = sample(cards.rem,1);
		#print(c(brd,nextcard));
		res = evaluateboard(c(brd, nextcard));
		sfreq[res] = sfreq[res] + 1;
  }
 
  endtime = proc.time();
  elapsed = endtime[3] - starttime[3];
  srate = n / elapsed;
  if (debug) { print( paste("Time: ", elapsed, "Rate/s: ", srate)  , quote = FALSE); }
  return(sfreq);
  
}

