/*

SynthPatterns Class,
Creates all synth sequences of varying rhythm, melodic lines and chord progressions according to human features.
(c) 2013-2014, Candidate Number 19329

*/

SynthPatterns {

	// Minor patterns for synth Solo1.
	var straightMinorSoloP1, straightMinorSoloP2, straightMinorSoloP3, straightMinorSolo;
	var straightOffMinorSoloP1, straightOffMinorSoloP2, straightOffMinorSoloP3, straightOffMinorSolo;
	var offMinorSoloP1, offMinorSoloP2, offMinorSoloP3, offMinorSolo;
	var tripletMinorSoloP1, tripletMinorSoloP2, tripletMinorSoloP3, tripletMinorSolo;

	// Major patterns for synth Solo1.
	var straightMajorSoloP1, straightMajorSoloP2, straightMajorSoloP3, straightMajorSolo;
	var straightOffMajorSoloP1, straightOffMajorSoloP2, straightOffMajorSoloP3, straightOffMajorSolo;
	var offMajorSoloP1, offMajorSoloP2, offMajorSoloP3, offMajorSolo;
	var tripletMajorSoloP1, tripletMajorSoloP2, tripletMajorSoloP3, tripletMajorSolo;

	// Minor patterns for synth chrd1.
	var straightMinorChrd1P1, straightMinorChrd1P2, straightMinorChrd1P3, straightMinorChrd1;
	var straightOffMinorChrd1P1, straightOffMinorChrd1P2, straightOffMinorChrd1P3, straightOffMinorChrd1;
	var offMinorChrd1P1, offMinorChrd1P2, offMinorChrd1P3, offMinorChrd1;
	var tripletMinorChrd1P1, tripletMinorChrd1P2, tripletMinorChrd1P3, tripletMinorChrd1;

	// Major patterns for synth chrd1.
	var straightMajorChrd1P1, straightMajorChrd1P2, straightMajorChrd1P3, straightMajorChrd1;
	var straightOffMajorChrd1P1, straightOffMajorChrd1P2, straightOffMajorChrd1P3, straightOffMajorChrd1;
	var offMajorChrd1P1, offMajorChrd1P2, offMajorChrd1P3, offMajorChrd1;
	var tripletMajorChrd1P1, tripletMajorChrd1P2, tripletMajorChrd1P3, tripletMajorChrd1;

	// Minor Harmony variables for synth chrd1:
	var straightMinorChrd1P1H11, straightMinorChrd1P1H21, straightMinorChrd1P1H31, straightMinorChrd1P1H41, straightMinorChord1Prog1;
	var straightMinorChrd1P1H12, straightMinorChrd1P1H22, straightMinorChrd1P1H32, straightMinorChrd1P1H42, straightMinorChord1Prog2;
	var straightMinorChrd1P1H13, straightMinorChrd1P1H23, straightMinorChrd1P1H33, straightMinorChrd1P1H43, straightMinorChord1Prog3;
	var straightOffMinorChrd1P1H11, straightOffMinorChrd1P1H21, straightOffMinorChrd1P1H31, straightOffMinorChrd1P1H41, straightOffMinorChord1Prog1;
	var straightOffMinorChrd1P1H12, straightOffMinorChrd1P1H22, straightOffMinorChrd1P1H32, straightOffMinorChrd1P1H42, straightOffMinorChord1Prog2;
	var straightOffMinorChrd1P1H13, straightOffMinorChrd1P1H23, straightOffMinorChrd1P1H33, straightOffMinorChrd1P1H43, straightOffMinorChord1Prog3;
	var offMinorChrd1P1H11, offMinorChrd1P1H21, offMinorChrd1P1H31, offMinorChrd1P1H41, offMinorChord1Prog1;
	var offMinorChrd1P1H12, offMinorChrd1P1H22, offMinorChrd1P1H32, offMinorChrd1P1H42, offMinorChord1Prog2;
	var offMinorChrd1P1H13, offMinorChrd1P1H23, offMinorChrd1P1H33, offMinorChrd1P1H43, offMinorChord1Prog3;
	var tripletMinorChrd1P1H11, tripletMinorChrd1P1H21, tripletMinorChrd1P1H31, tripletMinorChrd1P1H41, tripletMinorChord1Prog1;
	var tripletMinorChrd1P1H12, tripletMinorChrd1P1H22, tripletMinorChrd1P1H32, tripletMinorChrd1P1H42, tripletMinorChord1Prog2;
	var tripletMinorChrd1P1H13, tripletMinorChrd1P1H23, tripletMinorChrd1P1H33, tripletMinorChrd1P1H43, tripletMinorChord1Prog3;

	// Major Harmony variables for synth chrd1:
	var straightMajorChrd1P1H11, straightMajorChrd1P1H21, straightMajorChrd1P1H31, straightMajorChrd1P1H41, straightMajorChord1Prog1;
	var straightMajorChrd1P1H12, straightMajorChrd1P1H22, straightMajorChrd1P1H32, straightMajorChrd1P1H42, straightMajorChord1Prog2;
	var straightMajorChrd1P1H13, straightMajorChrd1P1H23, straightMajorChrd1P1H33, straightMajorChrd1P1H43, straightMajorChord1Prog3;
	var straightOffMajorChrd1P1H11, straightOffMajorChrd1P1H21, straightOffMajorChrd1P1H31, straightOffMajorChrd1P1H41, straightOffMajorChord1Prog1;
	var straightOffMajorChrd1P1H12, straightOffMajorChrd1P1H22, straightOffMajorChrd1P1H32, straightOffMajorChrd1P1H42, straightOffMajorChord1Prog2;
	var straightOffMajorChrd1P1H13, straightOffMajorChrd1P1H23, straightOffMajorChrd1P1H33, straightOffMajorChrd1P1H43, straightOffMajorChord1Prog3;
	var offMajorChrd1P1H11, offMajorChrd1P1H21, offMajorChrd1P1H31, offMajorChrd1P1H41, offMajorChord1Prog1;
	var offMajorChrd1P1H12, offMajorChrd1P1H22, offMajorChrd1P1H32, offMajorChrd1P1H42, offMajorChord1Prog2;
	var offMajorChrd1P1H13, offMajorChrd1P1H23, offMajorChrd1P1H33, offMajorChrd1P1H43, offMajorChord1Prog3;
	var tripletMajorChrd1P1H11, tripletMajorChrd1P1H21, tripletMajorChrd1P1H31, tripletMajorChrd1P1H41, tripletMajorChord1Prog1;
	var tripletMajorChrd1P1H12, tripletMajorChrd1P1H22, tripletMajorChrd1P1H32, tripletMajorChrd1P1H42, tripletMajorChord1Prog2;
	var tripletMajorChrd1P1H13, tripletMajorChrd1P1H23, tripletMajorChrd1P1H33, tripletMajorChrd1P1H43, tripletMajorChord1Prog3;

	*new {

		^super.newCopyArgs();
	}


	setPatterns { arg root = 5;

		var r = root+20, major = [1, 2, 3, 4, 5, 6], minor = [1, 2, 3, 4, 5, 6];
		major[0] = r+2; // ii
		major[1] = r+4; // iii
		major[2] = r+5; // IV
		major[3] = r+7; // V
		major[4] = r+9; // vi
		major[5] = r+11; // vii

		minor[0] = r+2; // ii
		minor[1] = r+3; // III
		minor[2] = r+5; // iv
		minor[3] = r+7; // V
		minor[4] = r+8; // VI
		minor[5] = r+11; // vii

		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Minor Solo Synth Patterns:

		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Minor Straight Patterns:
		//1st 5,
		straightMinorSoloP1 = Pseq([[r, 0.5], [(r+3), 0.5], [\, 0.5], [\, 0.5], [(r+5), 0.5], [(r+7), 0.5], [(r+8), 1.0]], 4);
		// 2nd 5,
		straightMinorSoloP2 = Pseq([[r, 1.0], [(r+2), 1.0], [(r+3), 1.0], [(r+5), 0.5], [(r+7), 0.5]], 4);
		// 3rd 5,
		straightMinorSoloP3 = Pseq([[\, 1.0], [(r+2), 0.5], [(r+3), 0.5], [(r+5), 0.5], [(r+7), 0.5], [(r+11), 1.0]], 4);
		//randomly select one of the straightMinor patterns:
		straightMinorSolo = [straightMinorSoloP1, straightMinorSoloP2, straightMinorSoloP3].choose;

		// Minor StraightOff Patterns:
		//1st 5,
		straightOffMinorSoloP1 = Pseq([[r, 0.5], [(r+3), 0.25], [\, 0.25], [(r+2), 0.25], [(r+5), 0.25], [\, 0.25], [(r+8), 0.25]],8);
		// 2nd 5,
		straightOffMinorSoloP2 = Pseq([[r, 1.0], [(r+2), 1.0], [(r+3), 1.0], [(r+5), 0.5], [(r+7), 0.5]], 4);
		// 3rd 5,
		straightOffMinorSoloP3 = Pseq([[\, 0.5], [(r+2), 0.25], [(r+3), 0.25], [\, 0.5], [(r+11), 0.25], [\, 0.25], [\, 0.25], [(r+5), 0.25], [(r+8), 1.5]], 4);
		//randomly select one of the straightOffMinor patterns:
		straightOffMinorSolo = [straightOffMinorSoloP1, straightOffMinorSoloP2, straightOffMinorSoloP3].choose;

		// Minor off Patterns:
		//1st 5,
		offMinorSoloP1 = Pseq([[r, 0.5], [(r+3), 0.5], [\, 0.5], [(r+2), 0.5], [\, 0.5], [r, 0.5], [\, 0.5], [(r+11), 0.25], [\, 0.125], [r, 0.125]], 4);
		// 2nd 5,
		offMinorSoloP2 = Pseq([[\, 0.25], [(r+2), 0.25], [\, 0.25], [\, 0.25], [(r+7), 0.25], [\, 0.25], [(r+3), 0.25], [(r+3), 0.25], [(r+8), 0.5], [(r+11), 0.5], [\, 1.0]], 4);
		// 3rd 5,
		offMinorSoloP3 = Pseq([[\, 0.125], [(r+3), 0.5], [\, 0.5], [(r+5), 0.5], [\, 0.25], [(r+11), 0.75], [r, 0.75], [\, 0.125], [(r+8), 0.5]], 4);
		//randomly select one of the offMinor patterns:
		offMinorSolo = [offMinorSoloP1, offMinorSoloP2, offMinorSoloP3].choose;

		// Minor Triplet Patterns:
		//1st 5,
		tripletMinorSoloP1 = Pseq([[r, 1.0], [(r+3), 1.0], [(r+7), 0.33333333333333], [(r+2), 0.33333333333333], [(r+8), 0.33333333333333], [\, 1.0]], 4);
		// 2nd 5,
		tripletMinorSoloP2 = Pseq([[r, 0.33333333333333], [(r+2), 0.33333333333333], [(r+3), 0.33333333333333], [(r+11), 0.33333333333333], [\, 0.33333333333333], [(r+8), 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333]],4);
		// 3rd 5,
		tripletMinorSoloP3 = Pseq([[(r+8), 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333], [(r+5), 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333], [(r+3), 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333], [r, 0.33333333333333], [\, 0.33333333333333], [(r+2), 0.33333333333333]], 4);
		//randomly select one of the tripletMinor patterns:
		tripletMinorSolo = [tripletMinorSoloP1, tripletMinorSoloP2, tripletMinorSoloP3].choose;


		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Major Solo Synth Patterns:

		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Major Straight Patterns:
		//1st 5,
		straightMajorSoloP1 = Pseq([[r, 0.5], [(r+4), 0.5], [\, 0.5], [\, 0.5], [(r+5), 0.5], [(r+7), 0.5], [(r+9), 1.0]], 4);
		// 2nd 5,
		straightMajorSoloP2 = Pseq([[r, 1.0], [(r+4), 1.0], [(r+7), 1.0], [(r+5), 0.5], [(r+7), 0.5]], 4);
		// 3rd 5,
		straightMajorSoloP3 = Pseq([[\, 1.0], [(r+4), 0.5], [r, 0.5], [(r+5), 0.5], [(r+7), 0.5], [(r+11), 1.0]], 4);
		//randomly select one of the straightMinor patterns:
		straightMajorSolo = [straightMajorSoloP1, straightMajorSoloP2, straightMajorSoloP3].choose;

		// Major StraightOff Patterns:
		//1st 5,
		straightOffMajorSoloP1 = Pseq([[r, 0.5], [(r+4), 0.25], [\, 0.25], [(r+2), 0.25], [(r+5), 0.25], [\, 0.25], [(r+9), 0.25]],8);
		// 2nd 5,
		straightOffMajorSoloP2 = Pseq([[r, 1.0], [(r+2), 1.0], [(r+4), 1.0], [(r+5), 0.5], [(r+7), 0.5]], 4);
		// 3rd 5,
		straightOffMajorSoloP3 = Pseq([[\, 0.5], [(r+2), 0.25], [(r+4), 0.25], [\, 0.5], [(r+11), 0.25], [\, 0.25], [\, 0.25], [(r+5), 0.25], [(r+9), 1.5]], 4);
		//randomly select one of the straightOffMinor patterns:
		straightOffMajorSolo = [straightOffMajorSoloP1, straightOffMajorSoloP2, straightOffMajorSoloP3].choose;

		// Major off Patterns:
		//1st 5,
		offMajorSoloP1 = Pseq([[r, 0.5], [(r+4), 0.5], [\, 0.5], [(r+2), 0.5], [\, 0.5], [r, 0.5], [\, 0.5], [(r+11), 0.25], [\, 0.125], [r, 0.125]], 4);
		// 2nd 5,
		offMajorSoloP2 = Pseq([[\, 0.25], [(r+2), 0.25], [\, 0.25], [\, 0.25], [(r+7), 0.25], [\, 0.25], [(r+4), 0.25], [(r+4), 0.25], [(r+9), 0.5], [(r+11), 0.5], [\, 1.0]], 4);
		// 3rd 5,
		offMajorSoloP3 = Pseq([[\, 0.125], [(r+4), 0.5], [\, 0.5], [(r+5), 0.5], [\, 0.25], [(r+11), 0.75], [r, 0.75], [\, 0.125], [(r+9), 0.5]], 4);
		//randomly select one of the offMinor patterns:
		offMajorSolo = [offMajorSoloP1, offMajorSoloP2, offMajorSoloP3].choose;

		// Major Triplet Patterns:
		//1st 5,
		tripletMajorSoloP1 = Pseq([[r, 1.0], [(r+4), 1.0], [(r+7), 0.33333333333333], [(r+2), 0.33333333333333], [(r+9), 0.33333333333333], [\, 1.0]], 4);
		// 2nd 5,
		tripletMajorSoloP2 = Pseq([[r, 0.33333333333333], [(r+2), 0.33333333333333], [(r+4), 0.33333333333333], [(r+11), 0.33333333333333], [\, 0.33333333333333], [(r+9), 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333]], 4);
		// 3rd 5,
		tripletMajorSoloP3 = Pseq([[(r+9), 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333], [(r+5), 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333], [(r+4), 0.33333333333333], [\, 0.33333333333333], [\, 0.33333333333333], [r, 0.33333333333333], [\, 0.33333333333333], [(r+2), 0.33333333333333]], 4);
		//randomly select one of the tripletMinor patterns:
		tripletMajorSolo = [tripletMajorSoloP1, tripletMajorSoloP2, tripletMajorSoloP3].choose;


		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Minor Chrd1 Synth Patterns:

		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		// 1st Striaght Chord progressions:
		//1:straight i, VI, iv, V.
		straightMinorChrd1P1 = Pseq([[r, 4.0], [minor[4], 4.0], [minor[2], 4.0], [minor[3], 4.0]]);
		straightMinorChrd1P1H11 = Pseq([(r+3).midicps, (minor[4]+4).midicps, (minor[2]+3).midicps, (minor[3]+4).midicps]);
		straightMinorChrd1P1H21 = Pseq([(r+7).midicps, (minor[4]+7).midicps, (minor[2]+7).midicps, (minor[3]+7).midicps]);
		straightMinorChrd1P1H31 = Pseq([(r+8).midicps, (minor[4]+9).midicps, (minor[2]+8).midicps, (minor[3]+9).midicps]);
		straightMinorChrd1P1H41 = Pseq([(r+12).midicps, (minor[4]+12).midicps, (minor[2]+12).midicps, (minor[3]+12).midicps]);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		straightMinorChord1Prog1 = [straightMinorChrd1P1, straightMinorChrd1P1H11, straightMinorChrd1P1H21, straightMinorChrd1P1H31, straightMinorChrd1P1H41];

		//2:straight i, iv, vii, III.
		straightMinorChrd1P2 = Pseq([[r, 4.0], [minor[2], 4.0], [minor[5], 4.0], [minor[1], 4.0]]);
		straightMinorChrd1P1H12 = Pseq([(r+3).midicps, (minor[2]+3).midicps, (minor[5]+3).midicps, (minor[1]+4).midicps]);
		straightMinorChrd1P1H22 = Pseq([(r+7).midicps, (minor[2]+7).midicps, (minor[5]+7).midicps, (minor[1]+7).midicps]);
		straightMinorChrd1P1H32 = Pseq([(r+8).midicps, (minor[2]+8).midicps, (minor[5]+8).midicps, (minor[1]+9).midicps]);
		straightMinorChrd1P1H42 = Pseq([(r+12).midicps, (minor[2]+12).midicps, (minor[5]+12).midicps, (minor[1]+12).midicps]);
		// Put in an array
		straightMinorChord1Prog2 = [straightMinorChrd1P2, straightMinorChrd1P1H12, straightMinorChrd1P1H22, straightMinorChrd1P1H32, straightMinorChrd1P1H42];

		//3:straight i, iv, ii, V.
		straightMinorChrd1P3 = Pseq([[r, 4.0], [minor[2], 4.0], [minor[0], 4.0], [minor[3], 4.0]]);
		straightMinorChrd1P1H13 = Pseq([(r+3).midicps, (minor[2]+3).midicps, (minor[0]+3).midicps, (minor[3]+4).midicps]);
		straightMinorChrd1P1H23 = Pseq([(r+7).midicps, (minor[2]+7).midicps, (minor[0]+7).midicps, (minor[3]+7).midicps]);
		straightMinorChrd1P1H33 = Pseq([(r+8).midicps, (minor[2]+8).midicps, (minor[0]+8).midicps, (minor[3]+9).midicps]);
		straightMinorChrd1P1H43 = Pseq([(r+12).midicps, (minor[2]+12).midicps, (minor[0]+12).midicps, (minor[3]+12).midicps]);
		// Put in an array
		straightMinorChord1Prog3 = [straightMinorChrd1P3, straightMinorChrd1P1H13, straightMinorChrd1P1H23, straightMinorChrd1P1H33, straightMinorChrd1P1H43];

		// Randomly pick a chord progression from the straight Minor: (I can alter the rhythm here for each one)
		straightMinorChrd1 = [straightMinorChord1Prog1, straightMinorChord1Prog2, straightMinorChord1Prog3].choose;


		// 2nd StriaghtOff Chord progressions:
		//1:straightOff i, VI, iv, V.
		straightOffMinorChrd1P1 = Pseq([[r, 7.0], [minor[4], 1.0], [minor[2], 7.0], [minor[3], 1.0]]);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		straightOffMinorChord1Prog1 = [straightOffMinorChrd1P1, straightMinorChrd1P1H11, straightMinorChrd1P1H21, straightMinorChrd1P1H31, straightMinorChrd1P1H41];

		//2:straightOff i, iv, Vii, III.
		straightOffMinorChrd1P2 = Pseq([[r, 7.0], [minor[2], 1.0], [minor[5], 7.0], [minor[1], 1.0]]);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		straightOffMinorChord1Prog2 = [straightOffMinorChrd1P2, straightMinorChrd1P1H12, straightMinorChrd1P1H22, straightMinorChrd1P1H32, straightMinorChrd1P1H42];

		//3:straightOff i, iv, ii, V.
		straightOffMinorChrd1P3 = Pseq([[r, 7.0], [minor[2], 1.0], [minor[0], 7.0], [minor[3], 1.0]]);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		straightOffMinorChord1Prog3 = [straightOffMinorChrd1P3, straightMinorChrd1P1H13, straightMinorChrd1P1H23, straightMinorChrd1P1H33, straightMinorChrd1P1H43];

		// Randomly pick a chord progression from the straightOff Minor:
		straightOffMinorChrd1 = [straightOffMinorChord1Prog1, straightOffMinorChord1Prog2, straightOffMinorChord1Prog3].choose;


		// 3rd Off Chord progressions:
		//1:off i, VI, iv, V.
		offMinorChrd1P1 = Pseq([[\, 2.0], [r, 2.0], [\, 2.0], [minor[4], 2.0], [\, 2.0], [minor[2], 2.0], [\, 2.0], [minor[3], 2.0]]);
		offMinorChrd1P1H11 = Pseq([\, (r+3).midicps, \, (minor[4]+4).midicps, \, (minor[2]+3).midicps, \, (minor[3]+4).midicps]);
		offMinorChrd1P1H21 = Pseq([\, (r+7).midicps, \, (minor[4]+7).midicps, \, (minor[2]+7).midicps, \, (minor[3]+7).midicps]);
		offMinorChrd1P1H31 = Pseq([\, (r+8).midicps, \, (minor[4]+9).midicps, \, (minor[2]+8).midicps, \, (minor[3]+9).midicps]);
		offMinorChrd1P1H41 = Pseq([\, (r+12).midicps, \, (minor[4]+12).midicps, \, (minor[2]+12).midicps, \, (minor[3]+12).midicps]);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		offMinorChord1Prog1 = [offMinorChrd1P1, offMinorChrd1P1H11, offMinorChrd1P1H21, offMinorChrd1P1H31, offMinorChrd1P1H41];

		//2:off i, iv, Vii, III.
		offMinorChrd1P2 = Pseq([[\, 2.0], [r, 2.0], [\, 2.0], [minor[4], 2.0], [\, 2.0], [minor[5], 2.0], [\, 2.0], [minor[1], 2.0]]);
		offMinorChrd1P1H12 = Pseq([\, (r+3).midicps, \, (minor[4]+3).midicps, \, (minor[5]+3).midicps, \, (minor[1]+4).midicps]);
		offMinorChrd1P1H22 = Pseq([\, (r+7).midicps, \, (minor[4]+7).midicps, \, (minor[5]+7).midicps, \, (minor[1]+7).midicps]);
		offMinorChrd1P1H32 = Pseq([\, (r+8).midicps, \, (minor[4]+8).midicps, \, (minor[5]+8).midicps, \, (minor[1]+9).midicps]);
		offMinorChrd1P1H42 = Pseq([\, (r+12).midicps, \, (minor[4]+12).midicps, \, (minor[5]+12).midicps, \, (minor[1]+12).midicps]);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		offMinorChord1Prog2 = [offMinorChrd1P2, offMinorChrd1P1H12, offMinorChrd1P1H22, offMinorChrd1P1H32, offMinorChrd1P1H42];

		//3:off, i, iv, ii, V.
		offMinorChrd1P3 = Pseq([[\, 2.0], [r, 2.0], [\, 2.0], [minor[2], 2.0], [\, 2.0], [minor[0], 2.0], [\, 2.0], [minor[3], 2.0]]);
		offMinorChrd1P1H13 = Pseq([\, (r+3).midicps, \, (minor[4]+3).midicps, \, (minor[5]+3).midicps, \, (minor[1]+4).midicps]);
		offMinorChrd1P1H23 = Pseq([\, (r+7).midicps, \, (minor[4]+7).midicps, \, (minor[5]+7).midicps, \, (minor[1]+7).midicps]);
		offMinorChrd1P1H33 = Pseq([\, (r+8).midicps, \, (minor[4]+8).midicps, \, (minor[5]+8).midicps, \, (minor[1]+9).midicps]);
		offMinorChrd1P1H43 = Pseq([\, (r+12).midicps, \, (minor[4]+12).midicps, \, (minor[5]+12).midicps, \, (minor[1]+12).midicps]);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		offMinorChord1Prog3 = [offMinorChrd1P3, offMinorChrd1P1H13, offMinorChrd1P1H23, offMinorChrd1P1H33, offMinorChrd1P1H43];

		// Randomly pick a chord progression from the off Minor:
		offMinorChrd1 = [offMinorChord1Prog1, offMinorChord1Prog2, offMinorChord1Prog3].choose;

		// 4th Triplet Chord progressions:
		//1:triplet i, VI, iv, v.
		tripletMinorChrd1P1 = Pseq([[r, 2.0], [minor[4], 0.66666666666666], [minor[2], 0.66666666666666], [minor[3], 0.66666666666666]], 4);
		tripletMinorChrd1P1H11 = Pseq([(r+3).midicps, (minor[4]+4).midicps, (minor[2]+3).midicps, (minor[3]+4).midicps],4);
		tripletMinorChrd1P1H21 = Pseq([(r+7).midicps, (minor[4]+7).midicps, (minor[2]+7).midicps, (minor[3]+7).midicps],4);
		tripletMinorChrd1P1H31 = Pseq([(r+8).midicps, (minor[4]+9).midicps, (minor[2]+8).midicps, (minor[3]+9).midicps],4);
		tripletMinorChrd1P1H41 = Pseq([(r+12).midicps, (minor[4]+12).midicps, (minor[2]+12).midicps, (minor[3]+12).midicps],4);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		tripletMinorChord1Prog1 = [tripletMinorChrd1P1, tripletMinorChrd1P1H11, tripletMinorChrd1P1H21, tripletMinorChrd1P1H31, tripletMinorChrd1P1H41];

		//2:triplet i, iv, Vii, III.
		tripletMinorChrd1P2 = Pseq([[r, 2.0], [minor[4], 0.66666666666666], [minor[5], 0.66666666666666], [minor[1], 0.66666666666666]], 4);
		tripletMinorChrd1P1H12 = Pseq([(r+3).midicps, (minor[4]+3).midicps, (minor[5]+3).midicps, (minor[1]+4).midicps],4);
		tripletMinorChrd1P1H22 = Pseq([(r+7).midicps, (minor[4]+7).midicps, (minor[5]+7).midicps, (minor[1]+7).midicps],4);
		tripletMinorChrd1P1H32 = Pseq([(r+8).midicps, (minor[4]+8).midicps, (minor[5]+8).midicps, (minor[1]+9).midicps],4);
		tripletMinorChrd1P1H42 = Pseq([(r+12).midicps, (minor[4]+12).midicps, (minor[5]+12).midicps, (minor[1]+12).midicps],4);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		tripletMinorChord1Prog2 = [tripletMinorChrd1P2, tripletMinorChrd1P1H12, tripletMinorChrd1P1H22, tripletMinorChrd1P1H32, tripletMinorChrd1P1H42];

		//3:triplet i, iv, ii, v.
		tripletMinorChrd1P3 = Pseq([[r, 2.0], [minor[2], 0.66666666666666], [minor[0], 0.66666666666666], [minor[3], 0.66666666666666]], 4);
		tripletMinorChrd1P1H13 = Pseq([(r+3).midicps, (minor[2]+3).midicps, (minor[0]+3).midicps, (minor[3]+4).midicps],4);
		tripletMinorChrd1P1H23 = Pseq([(r+7).midicps, (minor[2]+7).midicps, (minor[0]+7).midicps, (minor[3]+7).midicps],4);
		tripletMinorChrd1P1H33 = Pseq([(r+8).midicps, (minor[2]+8).midicps, (minor[0]+8).midicps, (minor[3]+9).midicps],4);
		tripletMinorChrd1P1H43 = Pseq([(r+12).midicps, (minor[2]+12).midicps, (minor[0]+12).midicps, (minor[3]+12).midicps],4);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		tripletMinorChord1Prog3 = [tripletMinorChrd1P3, tripletMinorChrd1P1H13, tripletMinorChrd1P1H23, tripletMinorChrd1P1H33, tripletMinorChrd1P1H43];

		// Randomly pick a chord progression from the triplet Minor:
		tripletMinorChrd1 = [tripletMinorChord1Prog1, tripletMinorChord1Prog2, tripletMinorChord1Prog3].choose;


		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Major Chrd1 Synth Patterns:

		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		// 1st Striaght Chord progressions:
		//1:straight I, vi, IV, V.
		straightMajorChrd1P1 = Pseq([[r, 4.0], [major[4], 4.0], [major[2], 4.0], [major[3], 4.0]]);
		straightMajorChrd1P1H11 = Pseq([(r+4).midicps, (major[4]+3).midicps, (major[2]+4).midicps, (major[3]+4).midicps]);
		straightMajorChrd1P1H21 = Pseq([(r+7).midicps, (major[4]+7).midicps, (major[2]+7).midicps, (major[3]+7).midicps]);
		straightMajorChrd1P1H31 = Pseq([(r+9).midicps, (major[4]+8).midicps, (major[2]+9).midicps, (major[3]+9).midicps]);
		straightMajorChrd1P1H41 = Pseq([(r+12).midicps, (major[4]+12).midicps, (major[2]+12).midicps, (major[3]+12).midicps]);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		straightMajorChord1Prog1 = [straightMajorChrd1P1, straightMajorChrd1P1H11, straightMajorChrd1P1H21, straightMajorChrd1P1H31, straightMajorChrd1P1H41];

		//2:straight I, IV, vii, iii.
		straightMajorChrd1P2 = Pseq([[r, 4.0], [major[2], 4.0], [major[5], 4.0], [major[1], 4.0]]);
		straightMajorChrd1P1H12 = Pseq([(r+4).midicps, (major[2]+4).midicps, (major[5]+3).midicps, (major[1]+3).midicps]);
		straightMajorChrd1P1H22 = Pseq([(r+7).midicps, (major[2]+7).midicps, (major[5]+7).midicps, (major[1]+7).midicps]);
		straightMajorChrd1P1H32 = Pseq([(r+9).midicps, (major[2]+9).midicps, (major[5]+8).midicps, (major[1]+8).midicps]);
		straightMajorChrd1P1H42 = Pseq([(r+12).midicps, (major[2]+12).midicps, (major[5]+12).midicps, (major[1]+12).midicps]);
		// Put in an array
		straightMajorChord1Prog2 = [straightMajorChrd1P2, straightMajorChrd1P1H12, straightMajorChrd1P1H22, straightMajorChrd1P1H32, straightMajorChrd1P1H42];

		//3:straight I, IV, ii, V.
		straightMajorChrd1P3 = Pseq([[r, 4.0], [major[2], 4.0], [major[0], 4.0], [major[3], 4.0]]);
		straightMajorChrd1P1H13 = Pseq([(r+4).midicps, (major[2]+4).midicps, (major[0]+3).midicps, (major[3]+4).midicps]);
		straightMajorChrd1P1H23 = Pseq([(r+7).midicps, (major[2]+7).midicps, (major[0]+7).midicps, (major[3]+7).midicps]);
		straightMajorChrd1P1H33 = Pseq([(r+9).midicps, (major[2]+9).midicps, (major[0]+8).midicps, (major[3]+9).midicps]);
		straightMajorChrd1P1H43 = Pseq([(r+12).midicps, (major[2]+12).midicps, (major[0]+12).midicps, (major[3]+12).midicps]);
		// Put in an array
		straightMajorChord1Prog3 = [straightMajorChrd1P3, straightMajorChrd1P1H13, straightMajorChrd1P1H23, straightMajorChrd1P1H33, straightMajorChrd1P1H43];

		// Randomly pick a chord progression from the straight Major: (I can alter the rhythm here for each one)
		straightMajorChrd1 = [straightMajorChord1Prog1, straightMajorChord1Prog2, straightMajorChord1Prog3].choose;


		// 2nd StriaghtOff Chord progressions:
		//1:straightOff I, vi, IV, V.
		straightOffMajorChrd1P1 = Pseq([[r, 7.0], [major[4], 1.0], [major[2], 7.0], [major[3], 1.0]]);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		straightOffMajorChord1Prog1 = [straightOffMajorChrd1P1, straightMajorChrd1P1H11, straightMajorChrd1P1H21, straightMajorChrd1P1H31, straightMajorChrd1P1H41];

		//2:straightOff I, IV, Vii, iii.
		straightOffMajorChrd1P2 = Pseq([[r, 7.0], [major[2], 1.0], [major[5], 7.0], [major[1], 1.0]]);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		straightOffMajorChord1Prog2 = [straightOffMajorChrd1P2, straightMajorChrd1P1H12, straightMajorChrd1P1H22, straightMajorChrd1P1H32, straightMajorChrd1P1H42];

		//3:straightOff I, IV, ii, V.
		straightOffMajorChrd1P3 = Pseq([[r, 7.0], [major[2], 1.0], [major[0], 7.0], [major[3], 1.0]]);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		straightOffMajorChord1Prog3 = [straightOffMajorChrd1P3, straightMajorChrd1P1H13, straightMajorChrd1P1H23, straightMajorChrd1P1H33, straightMajorChrd1P1H43];

		// Randomly pick a chord progression from the straightOff Major:
		straightOffMajorChrd1 = [straightOffMajorChord1Prog1, straightOffMajorChord1Prog2, straightOffMajorChord1Prog3].choose;

		// 3rd Off Chord progressions:
		//1:off I, vi, IV, V.
		offMajorChrd1P1 = Pseq([[\, 2.0], [r, 2.0], [\, 2.0], [major[4], 2.0], [\, 2.0], [major[2], 2.0], [\, 2.0], [major[3], 2.0]]);
		offMajorChrd1P1H11 = Pseq([\, (r+4).midicps, \, (major[4]+3).midicps, \, (major[2]+4).midicps, \, (major[3]+4).midicps]);
		offMajorChrd1P1H21 = Pseq([\, (r+7).midicps, \, (major[4]+7).midicps, \, (major[2]+7).midicps, \, (major[3]+7).midicps]);
		offMajorChrd1P1H31 = Pseq([\, (r+9).midicps, \, (major[4]+8).midicps, \, (major[2]+9).midicps, \, (major[3]+9).midicps]);
		offMajorChrd1P1H41 = Pseq([\, (r+12).midicps, \, (major[4]+12).midicps, \, (major[2]+12).midicps, \, (major[3]+12).midicps]);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		offMajorChord1Prog1 = [offMajorChrd1P1, offMajorChrd1P1H11, offMajorChrd1P1H21, offMajorChrd1P1H31, offMajorChrd1P1H41];

		//2:off I, IV, vii, iii.
		offMajorChrd1P2 = Pseq([[\, 2.0], [r, 2.0], [\, 2.0], [major[4], 2.0], [\, 2.0], [major[5], 2.0], [\, 2.0], [major[1], 2.0]]);
		offMajorChrd1P1H12 = Pseq([\, (r+4).midicps, \, (major[4]+4).midicps, \, (major[5]+3).midicps, \, (major[1]+3).midicps]);
		offMajorChrd1P1H22 = Pseq([\, (r+7).midicps, \, (major[4]+7).midicps, \, (major[5]+7).midicps, \, (major[1]+7).midicps]);
		offMajorChrd1P1H32 = Pseq([\, (r+9).midicps, \, (major[4]+9).midicps, \, (major[5]+8).midicps, \, (major[1]+8).midicps]);
		offMajorChrd1P1H42 = Pseq([\, (r+12).midicps, \, (major[4]+12).midicps, \, (major[5]+12).midicps, \, (major[1]+12).midicps]);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		offMajorChord1Prog2 = [offMajorChrd1P2, offMajorChrd1P1H12, offMajorChrd1P1H22, offMajorChrd1P1H32, offMajorChrd1P1H42];

		//3:off, I, IV, ii, V.
		offMajorChrd1P3 = Pseq([[\, 2.0], [r, 2.0], [\, 2.0], [major[2], 2.0], [\, 2.0], [major[0], 2.0], [\, 2.0], [major[3], 2.0]]);
		offMajorChrd1P1H13 = Pseq([\, (r+4).midicps, \, (major[4]+4).midicps, \, (major[5]+3).midicps, \, (major[1]+4).midicps]);
		offMajorChrd1P1H23 = Pseq([\, (r+7).midicps, \, (major[4]+7).midicps, \, (major[5]+7).midicps, \, (major[1]+7).midicps]);
		offMajorChrd1P1H33 = Pseq([\, (r+9).midicps, \, (major[4]+9).midicps, \, (major[5]+8).midicps, \, (major[1]+9).midicps]);
		offMajorChrd1P1H43 = Pseq([\, (r+12).midicps, \, (major[4]+12).midicps, \, (major[5]+12).midicps, \, (major[1]+12).midicps]);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		offMajorChord1Prog3 = [offMajorChrd1P3, offMajorChrd1P1H13, offMajorChrd1P1H23, offMajorChrd1P1H33, offMajorChrd1P1H43];

		// Randomly pick a chord progression from the off Major:
		offMajorChrd1 = [offMajorChord1Prog1, offMajorChord1Prog2, offMajorChord1Prog3].choose;

		// 4th Triplet Chord progressions:
		//1:triplet I, vi, IV, V.
		tripletMajorChrd1P1 = Pseq([[r, 2.0], [major[4], 0.66666666666666], [major[2], 0.66666666666666], [major[3], 0.66666666666666]], 4);
		tripletMajorChrd1P1H11 = Pseq([(r+4).midicps, (major[4]+3).midicps, (major[2]+4).midicps, (major[3]+4).midicps],4);
		tripletMajorChrd1P1H21 = Pseq([(r+7).midicps, (major[4]+7).midicps, (major[2]+7).midicps, (major[3]+7).midicps],4);
		tripletMajorChrd1P1H31 = Pseq([(r+9).midicps, (major[4]+8).midicps, (major[2]+9).midicps, (major[3]+9).midicps],4);
		tripletMajorChrd1P1H41 = Pseq([(r+12).midicps, (major[4]+12).midicps, (major[2]+12).midicps, (major[3]+12).midicps],4);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		tripletMajorChord1Prog1 = [tripletMajorChrd1P1, tripletMajorChrd1P1H11, tripletMajorChrd1P1H21, tripletMajorChrd1P1H31, tripletMajorChrd1P1H41];

		//2:triplet I, IV, vii, iii.
		tripletMajorChrd1P2 = Pseq([[r, 2.0], [major[4], 0.66666666666666], [major[5], 0.66666666666666], [major[1], 0.66666666666666]], 4);
		tripletMajorChrd1P1H12 = Pseq([(r+4).midicps, (major[4]+4).midicps, (major[5]+3).midicps, (major[1]+3).midicps],4);
		tripletMajorChrd1P1H22 = Pseq([(r+7).midicps, (major[4]+7).midicps, (major[5]+7).midicps, (major[1]+7).midicps],4);
		tripletMajorChrd1P1H32 = Pseq([(r+9).midicps, (major[4]+9).midicps, (major[5]+8).midicps, (major[1]+8).midicps],4);
		tripletMajorChrd1P1H42 = Pseq([(r+12).midicps, (major[4]+12).midicps, (major[5]+12).midicps, (major[1]+12).midicps],4);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		tripletMajorChord1Prog2 = [tripletMajorChrd1P2, tripletMajorChrd1P1H12, tripletMajorChrd1P1H22, tripletMajorChrd1P1H32, tripletMajorChrd1P1H42];

		//3:triplet I, IV, ii, V.
		tripletMajorChrd1P3 = Pseq([[r, 2.0], [major[2], 0.66666666666666], [major[0], 0.66666666666666], [major[3], 0.66666666666666]], 4);
		tripletMajorChrd1P1H13 = Pseq([(r+4).midicps, (major[2]+4).midicps, (major[0]+3).midicps, (major[3]+4).midicps],4);
		tripletMajorChrd1P1H23 = Pseq([(r+7).midicps, (major[2]+7).midicps, (major[0]+7).midicps, (major[3]+7).midicps],4);
		tripletMajorChrd1P1H33 = Pseq([(r+9).midicps, (major[2]+9).midicps, (major[0]+8).midicps, (major[3]+9).midicps],4);
		tripletMajorChrd1P1H43 = Pseq([(r+12).midicps, (major[2]+12).midicps, (major[0]+12).midicps, (major[3]+12).midicps],4);
		// Put in an array 0 = root, 1 = harmony 1 etc.
		tripletMajorChord1Prog3 = [tripletMajorChrd1P3, tripletMajorChrd1P1H13, tripletMajorChrd1P1H23, tripletMajorChrd1P1H33, tripletMajorChrd1P1H43];

		// Randomly pick a chord progression from the triplet Major:
		tripletMajorChrd1 = [tripletMajorChord1Prog1, tripletMajorChord1Prog2, tripletMajorChord1Prog3].choose;

	}


	/*
	Getter methods for the Minor Solo Synth:
	*/

	//Return straightMinorSolo 5,
	getStraightMinorSolo {
		^straightMinorSolo.value;
	}

	//Return straightOffMinorSolo 5,
	getStraightOffMinorSolo {
		^straightOffMinorSolo.value;
	}

	//Return offMinorSolo 5,
	getOffMinorSolo {
		^offMinorSolo.value;
	}

	//Return tripletMajorSolo 5,
	getTripletMinorSolo {
		^tripletMinorSolo.value;
	}

	/*
	Getter methods for the Major Solo Synth:
	*/

	//Return straightMajorSolo 5,
	getStraightMajorSolo {
		^straightMajorSolo.value;
	}

	//Return straightOffMajorSolo 5,
	getStraightOffMajorSolo {
		^straightOffMajorSolo.value;
	}

	//Return offMajorSolo 5,
	getOffMajorSolo {
		^offMajorSolo.value;
	}

	//Return tripletMajorSolo 5,
	getTripletMajorSolo {
		^tripletMajorSolo.value;
	}

	/*
	Getter methods for the Minor Chrd1 Synth:
	*/

	//Return straightMinorChrd1,
	getStraightMinorChord {
		^straightMinorChrd1.value;
	}

	//Return straightOffMinorChrd1 5,
	getStraightOffMinorChord {
		^straightOffMinorChrd1.value;
	}

	//Return offMinorChrd1 5,
	getOffMinorChord {
		^offMinorChrd1.value;
	}

	//Return tripletMajorChrd1 5,
	getTripletMinorChord {
		^tripletMinorChrd1.value;
	}

	/*
	Getter methods for the Major Chrd1 Synth:
	*/

	//Return straightMajorChrd1,
	getStraightMajorChord {
		^straightMajorChrd1.value;
	}

	//Return straightOffMajorChrd1 5,
	getStraightOffMajorChord {
		^straightOffMajorChrd1.value;
	}

	//Return offMajorChrd1 5,
	getOffMajorChord {
		^offMajorChrd1.value;
	}

	//Return tripletMajorChrd1 5,
	getTripletMajorChord {
		^tripletMajorChrd1.value;
	}

}

