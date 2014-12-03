/*

DrumPatterns Class,
Creates all drum sequences of varying rhythm, according to human features.
(c) 2013-2014, Candidate Number 19329

*/
DrumPatterns {

	/*
	All the drum rhythm sequence variables:
	*/
	// <120 variables: (3 or less hits per bar)
	var straight120Freq1, straight120Dur1, straight120Freq2, straight120Dur2, straight120Freq3, straight120Dur3, <>straight120;
	var straightOff120Freq1, straightOff120Dur1, straightOff120Freq2, straightOff120Dur2, straightOff120Freq3, straightOff120Dur3, <>straightOff120;
	var off120Freq1, off120Dur1, off120Freq2, off120Dur2, off120Freq3, off120Dur3, <>off120;
	var triplet120Freq1, triplet120Dur1, triplet120Freq2, triplet120Dur2, triplet120Freq3, triplet120Dur3, <>triplet120;
	// 120-129 variables (4 hits per bar):
	var straight129Freq1, straight129Dur1, straight129Freq2, straight129Dur2, straight129Freq3, straight129Dur3, <>straight129;
	var straightOff129Freq1, straightOff129Dur1, straightOff129Freq2, straightOff129Dur2, straightOff129Freq3, straightOff129Dur3, <>straightOff129;
	var off129Freq1, off129Dur1, off129Freq2, off129Dur2, off129Freq3, off129Dur3, <>off129;
	var triplet129Freq1, triplet129Dur1, triplet129Freq2, triplet129Dur2, triplet129Freq3, triplet129Dur3, <>triplet129;
	// 130-139 variables (5 hits per bar):
	var straight130Freq1, straight130Dur1, straight130Freq2, straight130Dur2, straight130Freq3, straight130Dur3, <>straight130;
	var straightOff130Freq1, straightOff130Dur1, straightOff130Freq2, straightOff130Dur2, straightOff130Freq3, straightOff130Dur3, <>straightOff130;
	var off130Freq1, off130Dur1, off130Freq2, off130Dur2, off130Freq3, off130Dur3, <>off130;
	var triplet130Freq1, triplet130Dur1, triplet130Freq2, triplet130Dur2, triplet130Freq3, triplet130Dur3, <>triplet130;
	// 140-159 variables (6 hits per bar):
	var straight140Freq1, straight140Dur1, straight140Freq2, straight140Dur2, straight140Freq3, straight140Dur3, <>straight140;
	var straightOff140Freq1, straightOff140Dur1, straightOff140Freq2, straightOff140Dur2, straightOff140Freq3, straightOff140Dur3, <>straightOff140;
	var off140Freq1, off140Dur1, off140Freq2, off140Dur2, off140Freq3, off140Dur3, <>off140;
	var triplet140Freq1, triplet140Dur1, triplet140Freq2, triplet140Dur2, triplet140Freq3, triplet140Dur3, <>triplet140;
	// >=160 variables (7 hits per bar):
	var straight160Freq1, straight160Dur1, straight160Freq2, straight160Dur2, straight160Freq3, straight160Dur3, <>straight160;
	var straightOff160Freq1, straightOff160Dur1, straightOff160Freq2, straightOff160Dur2, straightOff160Freq3, straightOff160Dur3, <>straightOff160;
	var off160Freq1, off160Dur1, off160Freq2, off160Dur2, off160Freq3, off160Dur3, <>off160;
	var triplet160Freq1, triplet160Dur1, triplet160Freq2, triplet160Dur2, triplet160Freq3, triplet160Dur3, <>triplet160;

	*new {	arg

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// 3 or Less hits per bar:

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/*
		3 or less hits per bar: Straight
		*/
		//1st
		straight120Freq1 = Pseq([1, 0, 1, 0], 4),
		straight120Dur1 = Pseq([1.0, 1.0, 1.0, 1.0], 4),
		//2nd
		straight120Freq2 = Pseq([1, 0, 1, 1], 4),
		straight120Dur2 = Pseq([1.0, 1.0, 1.0, 1.0], 4),
		//3rd
		straight120Freq3 = Pseq([1, 1, 0, 1], 4),
		straight120Dur3 = Pseq([0.5, 0.5, 2.0, 1.0], 4),
		// randomly choose one of the three straight 3 or less hit rhythms.
		straight120 = [[straight120Freq1, straight120Dur1], [straight120Freq2, straight120Dur2], [straight120Freq3, straight120Dur3]].choose,

		/*
		3 or less hits per bar: StraightOff
		*/
		//1st
		straightOff120Freq1 = Pseq([1, 0, 1], 4),
		straightOff120Dur1 = Pseq([0.5, 3.0, 0.5], 4),
		//2nd
		straightOff120Freq2 = Pseq([0, 1, 1], 4),
		straightOff120Dur2 = Pseq([1.0, 1.0, 2.0], 4),
		//3rd
		straightOff120Freq3 = Pseq([1, 1, 0, 1], 4),
		straightOff120Dur3 = Pseq([0.25, 0.25, 1.0, 2.5], 4),
		// randomly choose one of the three straightOff 3 or less hit rhythms.
		straightOff120 = [[straightOff120Freq1, straightOff120Dur1], [straightOff120Freq2, straightOff120Dur2], [straightOff120Freq3, straightOff120Dur3]].choose,

		/*
		3 or less hits per bar: Off
		*/
		//1st
		off120Freq1 = Pseq([0, 1, 0, 1, 0], 4),
		off120Dur1 = Pseq([0.5, 0.5, 0.5, 0.5, 2.0], 4),
		//2nd
		off120Freq2 = Pseq([0, 1, 0, 1, 0, 1, 0], 4),
		off120Dur2 = Pseq([0.5, 0.5, 0.25, 0.25, 0.25, 0.25, 2.0], 4),
		//3rd
		off120Freq3 = Pseq([0, 1, 0], 4),
		off120Dur3 = Pseq([0.5, 0.5, 3.0], 4),
		// randomly choose one of the three off 3 or less hit rhythms.
		off120 = [[off120Freq1, off120Dur1], [off120Freq2, off120Dur2], [off120Freq3, off120Dur3]].choose,

		/*
		3 or less hits per bar: Triplet
		*/
		//1st
		triplet120Freq1 = Pseq([1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0], 4),
		triplet120Dur1 = Pseq([0.33333333333333, 0.33333333333333, 0.33333333333333], 16),
		//2nd
		triplet120Freq2 = Pseq([1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0], 4),
		triplet120Dur2 = Pseq([0.33333333333333, 0.33333333333333, 0.33333333333333], 16),
		//3rd
		triplet120Freq3 = Pseq([1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0], 4),
		triplet120Dur3 = Pseq([0.33333333333333, 0.33333333333333, 0.33333333333333], 16),
		// randomly choose one of the three triplet 3 or less hit rhythms.
		triplet120 = [[triplet120Freq1, triplet120Dur1], [triplet120Freq2, triplet120Dur2], [triplet120Freq3, triplet120Dur3]].choose,


		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// 4 hits per bar:

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/*
		4 hits per bar: Straight
		*/
		//1st
		straight129Freq1 = Pseq([1, 1, 1, 1], 4),
		straight129Dur1 = Pseq([1.0, 1.0, 1.0, 1.0], 4),
		//2nd
		straight129Freq2 = Pseq([0, 0, 0, 1, 1, 1, 1], 4),
		straight129Dur2 = Pseq([1.0, 1.0, 1.0, 0.25, 0.25, 0.25, 0.25], 4),
		//3rd
		straight129Freq3 = Pseq([1, 1, 0, 1, 1], 4),
		straight129Dur3 = Pseq([0.5, 0.5, 2.0, 0.5, 0.5], 4),
		// randomly choose one of the three straight 3 or less hit rhythms.
		straight129 = [[straight129Freq1, straight129Dur1], [straight129Freq2, straight129Dur2], [straight129Freq3, straight129Dur3]].choose,

		/*
		4 hits per bar: StraightOff
		*/
		//1st
		straightOff129Freq1 = Pseq([1, 1, 0, 1, 1], 4),
		straightOff129Dur1 = Pseq([0.5, 0.5, 0.5, 0.25, 0.25], 8),
		//2nd
		straightOff129Freq2 = Pseq([1, 0, 1, 1, 0, 0, 1], 4),
		straightOff129Dur2 = Pseq([1.0, 0.5, 0.25, 0.25, 0.25, 0.25, 1.5], 4),
		//3rd
		straightOff129Freq3 = Pseq([1, 1, 0, 0, 1, 1, 0], 4),
		straightOff129Dur3 = Pseq([0.25, 0.25, 1.5, 0.5, 0.75, 0.25, 0.5], 4),
		// randomly choose one of the three straightOff 3 or less hit rhythms.
		straightOff129 = [[straightOff129Freq1, straightOff129Dur1], [straightOff129Freq2, straightOff129Dur2], [straightOff129Freq3, straightOff129Dur3]].choose,

		/*
		4 hits per bar: Off
		*/
		//1st
		off129Freq1 = Pseq([0, 1], 4),
		off129Dur1 = Pseq([0.5, 0.5],16),
		//2nd
		off129Freq2 = Pseq([0, 1, 0, 1, 0, 1, 0, 1, 0], 4),
		off129Dur2 = Pseq([0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 2.0], 4),
		//3rd
		off129Freq3 = Pseq([0, 0, 0, 1, 0, 1, 1, 0, 1], 4),
		off129Dur3 = Pseq([0.125, 0.5, 0.5, 0.5, 0.25, 0.75, 0.75, 0.125, 0.5], 4),
		// randomly choose one of the three off 3 or less hit rhythms.
		off129 = [[off129Freq1, off129Dur1], [off129Freq2, off129Dur2], [off129Freq3, off129Dur3]].choose,

		/*
		4 hits per bar: Triplet
		*/
		//1st
		triplet129Freq1 = Pseq([1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0], 4),
		triplet129Dur1 = Pseq([0.33333333333333, 0.33333333333333, 0.33333333333333], 16),
		//2nd
		triplet129Freq2 = Pseq([1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0], 4),
		triplet129Dur2 = Pseq([0.33333333333333, 0.33333333333333, 0.33333333333333], 16),
		//3rd
		triplet129Freq3 = Pseq([1, 1, 1, 1, 1, 0], 4),
		triplet129Dur3 = Pseq([0.66666666666666, 0.66666666666666, 0.66666666666666, 0.66666666666666, 0.66666666666666, 0.66666666666666], 4),
		// randomly choose one of the three triplet 3 or less hit rhythms.
		triplet129 = [[triplet129Freq1, triplet129Dur1], [triplet129Freq2, triplet129Dur2], [triplet129Freq3, triplet129Dur3]].choose,


		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// 5 hits per bar:

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/*
		5 hits per bar: Straight
		*/
		//1st
		straight130Freq1 = Pseq([1, 1, 0, 0, 1, 1, 1], 4),
		straight130Dur1 = Pseq([0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1.0], 4),
		//2nd
		straight130Freq2 = Pseq([1, 1, 1, 1, 1], 4),
		straight130Dur2 = Pseq([1.0, 1.0, 1.0, 0.5, 0.5], 4),
		//3rd
		straight130Freq3 = Pseq([0, 1, 1, 1, 1, 1], 4),
		straight130Dur3 = Pseq([1.0, 0.5, 0.5, 0.5, 0.5, 1.0], 4),
		// randomly choose one of the three straight 3 or less hit rhythms.
		straight130 = [[straight130Freq1, straight130Dur1], [straight130Freq2, straight130Dur2], [straight130Freq3, straight130Dur3]].choose,

		/*
		5 hits per bar: StraightOff
		*/
		//1st
		straightOff130Freq1 = Pseq([1, 1, 0, 1, 1, 0, 1], 4),
		straightOff130Dur1 = Pseq([0.5, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25], 8),
		//2nd
		straightOff130Freq2 = Pseq([0, 1, 1, 0, 1, 0, 0, 1, 1], 4),
		straightOff130Dur2 = Pseq([0.5, 0.25, 0.25, 0.5, 0.25, 0.25, 0.25, 0.25, 1.5], 4),
		//3rd
		straightOff130Freq3 = Pseq([1, 1, 0, 1, 1, 1, 0], 4),
		straightOff130Dur3 = Pseq([0.25, 0.25, 1.5, 0.5, 0.75, 0.25, 0.5], 4),
		// randomly choose one of the three straightOff 3 or less hit rhythms.
		straightOff130 = [[straightOff130Freq1, straightOff130Dur1], [straightOff130Freq2, straightOff130Dur2], [straightOff130Freq3, straightOff130Dur3]].choose,

		/*
		5 hits per bar: Off
		*/
		//1st
		off130Freq1 = Pseq([0, 1, 0, 1, 0, 1, 0, 1, 0, 1], 4),
		off130Dur1 = Pseq([0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.25, 0.125, 0.125], 4),
		//2nd
		off130Freq2 = Pseq([0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0], 4),
		off130Dur2 = Pseq([0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.5, 0.5, 1.0], 4),
		//3rd
		off130Freq3 = Pseq([0, 1, 0, 1, 0, 1, 1, 0, 1], 4),
		off130Dur3 = Pseq([0.125, 0.5, 0.5, 0.5, 0.25, 0.75, 0.75, 0.125, 0.5], 4),
		// randomly choose one of the three off 3 or less hit rhythms.
		off130 = [[off130Freq1, off130Dur1], [off130Freq2, off130Dur2], [off130Freq3, off130Dur3]].choose,

		/*
		5 hits per bar: Triplet
		*/
		//1st
		triplet130Freq1 = Pseq([1, 1, 1, 1, 1, 0], 4),
		triplet130Dur1 = Pseq([1.0, 1.0, 0.33333333333333, 0.33333333333333, 0.33333333333333, 1.0], 4),
		//2nd
		triplet130Freq2 = Pseq([1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0], 4),
		triplet130Dur2 = Pseq([0.33333333333333, 0.33333333333333, 0.33333333333333], 16),
		//3rd
		triplet130Freq3 = Pseq([1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1], 4),
		triplet130Dur3 = Pseq([0.33333333333333, 0.33333333333333, 0.33333333333333], 16),
		// randomly choose one of the three triplet 3 or less hit rhythms.
		triplet130 = [[triplet130Freq1, triplet130Dur1], [triplet130Freq2, triplet130Dur2], [triplet130Freq3, triplet130Dur3]].choose,


		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// 6 hits per bar:

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/*
		6 hits per bar: Straight
		*/
		//1st
		straight140Freq1 = Pseq([1, 1, 1, 1, 1, 1, 0], 4),
		straight140Dur1 = Pseq([0.5, 0.5, 0.25, 0.25, 0.25, 0.25, 2.0], 4),
		//2nd
		straight140Freq2 = Pseq([1, 1, 1, 1, 1, 1, 0], 4),
		straight140Dur2 = Pseq([0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1.0], 4),
		//3rd
		straight140Freq3 = Pseq([1, 1, 1, 1, 1, 1], 4),
		straight140Dur3 = Pseq([1.0, 1.0, 0.5, 0.5, 0.5, 0.5], 4),
		// randomly choose one of the three straight 3 or less hit rhythms.
		straight140 = [[straight140Freq1, straight140Dur1], [straight140Freq2, straight140Dur2], [straight140Freq3, straight140Dur3]].choose,

		/*
		6 hits per bar: StraightOff
		*/
		//1st
		straightOff140Freq1 = Pseq([1, 1, 1, 0, 1, 1, 1, 0, 0], 4),
		straightOff140Dur1 = Pseq([0.5, 0.5, 0.5, 0.25, 0.25, 0.25, 0.25, 0.5, 1.0], 4),
		//2nd
		straightOff140Freq2 = Pseq([1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0], 4),
		straightOff140Dur2 = Pseq([0.5, 0.5, 0.5, 0.25, 0.25, 0.25, 0.25, 0.125, 0.25, 0.125, 0.5, 0.5], 4),
		//3rd
		straightOff140Freq3 = Pseq([1, 1, 1, 1, 1, 1], 4),
		straightOff140Dur3 = Pseq([0.25, 0.25, 1.5, 1.0, 0.5, 0.5], 4),
		// randomly choose one of the three straightOff 3 or less hit rhythms.
		straightOff140 = [[straightOff140Freq1, straightOff140Dur1], [straightOff140Freq2, straightOff140Dur2], [straightOff140Freq3, straightOff140Dur3]].choose,

		/*
		6 hits per bar: Off
		*/
		//1st
		off140Freq1 = Pseq([0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1], 4),
		off140Dur1 = Pseq([0.25, 0.25, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.25, 0.125, 0.125], 4),
		//2nd
		off140Freq2 = Pseq([0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1], 4),
		off140Dur2 = Pseq([0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.5, 0.5, 0.5, 0.5], 4),
		//3rd
		off140Freq3 = Pseq([0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1], 4),
		off140Dur3 = Pseq([0.125, 0.5, 0.5, 0.5, 0.25, 0.75, 0.75, 0.125, 0.25, 0.125, 0.125], 4),
		// randomly choose one of the three off 3 or less hit rhythms.
		off140 = [[off140Freq1, off140Dur1], [off140Freq2, off140Dur2], [off140Freq3, off140Dur3]].choose,

		/*
		6 hits per bar: Triplet
		*/
		//1st
		triplet140Freq1 = Pseq([1, 1, 1, 1, 1, 1], 4),
		triplet140Dur1 = Pseq([1.0, 1.0, 0.33333333333333, 0.33333333333333, 0.33333333333333, 1.0], 4),
		//2nd
		triplet140Freq2 = Pseq([1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0], 4),
		triplet140Dur2 = Pseq([0.33333333333333, 0.33333333333333, 0.33333333333333], 16),
		//3rd
		triplet140Freq3 = Pseq([1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1], 4),
		triplet140Dur3 = Pseq([0.33333333333333, 0.33333333333333, 0.33333333333333], 16),
		// randomly choose one of the three triplet 3 or less hit rhythms.
		triplet140 = [[triplet140Freq1, triplet140Dur1], [triplet140Freq2, triplet140Dur2], [triplet140Freq3, triplet140Dur3]].choose,


		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// 7 or more hits per bar:

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/*
		7 hits per bar: Straight
		*/
		//1st
		straight160Freq1 = Pseq([1, 0, 1, 1, 1, 1, 1, 1], 4),
		straight160Dur1 = Pseq([1.0, 1.0, 0.25, 0.25, 0.25, 0.25, 0.5, 0.5], 4),
		//2nd
		straight160Freq2 = Pseq([1, 1, 1, 1, 1, 1, 1], 4),
		straight160Dur2 = Pseq([0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1.0], 4),
		//3rd
		straight160Freq3 = Pseq([1, 1, 1, 1, 1, 1, 1], 4),
		straight160Dur3 = Pseq([1.0, 1.0, 0.5, 0.5, 0.5, 0.25, 0.25], 4),
		// randomly choose one of the three straight 3 or less hit rhythms.
		straight160 = [[straight160Freq1, straight160Dur1], [straight160Freq2, straight160Dur2], [straight160Freq3, straight160Dur3]].choose,

		/*
		7 hits per bar: StraightOff
		*/
		//1st
		straightOff160Freq1 = Pseq([1, 1, 1, 0, 1, 1, 0, 1, 1], 4),
		straightOff160Dur1 = Pseq([0.5, 1.0, 0.5, 0.5, 0.25, 0.25, 0.25, 0.25, 0.5], 4),
		//2nd
		straightOff160Freq2 = Pseq([1, 0, 1, 1, 1, 1, 0, 1, 0, 1], 4),
		straightOff160Dur2 = Pseq([0.5, 1.0, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.5, 0.5], 4),
		//3rd
		straightOff160Freq3 = Pseq([1, 1, 1, 1, 1, 1, 1], 4),
		straightOff160Dur3 = Pseq([0.25, 0.25, 1.5, 1.0, 0.5, 0.25, 0.25], 4),
		// randomly choose one of the three straightOff 3 or less hit rhythms.
		straightOff160 = [[straightOff160Freq1, straightOff160Dur1], [straightOff160Freq2, straightOff160Dur2], [straightOff160Freq3, straightOff160Dur3]].choose,

		/*
		7 hits per bar: Off
		*/
		//1st
		off160Freq1 = Pseq([0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1], 4),
		off160Dur1 = Pseq([0.25, 0.25, 0.25, 0.25, 0.5, 0.5, 0.5, 0.5, 0.5, 0.25, 0.125, 0.125], 4),
		//2nd
		off160Freq2 = Pseq([0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1], 4),
		off160Dur2 = Pseq([0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.5, 0.5, 0.5, 0.25, 0.25], 4),
		//3rd
		off160Freq3 = Pseq([0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1], 4),
		off160Dur3 = Pseq([0.125, 0.25, 0.25, 0.5, 0.5, 0.25, 0.75, 0.75, 0.125, 0.25, 0.125, 0.125], 4),
		// randomly choose one of the three off 3 or less hit rhythms.
		off160 = [[off160Freq1, off160Dur1], [off160Freq2, off160Dur2], [off160Freq3, off160Dur3]].choose,

		/*
		7 hits per bar: Triplet
		*/
		//1st
		triplet160Freq1 = Pseq([1, 1, 1, 1, 1, 1, 1], 4),
		triplet160Dur1 = Pseq([1.0, 1.0, 0.33333333333333, 0.33333333333333, 0.33333333333333, 0.5, 0.5], 4),
		//2nd
		triplet160Freq2 = Pseq([1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0], 4),
		triplet160Dur2 = Pseq([0.33333333333333, 0.33333333333333, 0.33333333333333], 16),
		//3rd
		triplet160Freq3 = Pseq([1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1], 4),
		triplet160Dur3 = Pseq([0.33333333333333, 0.33333333333333, 0.33333333333333], 16),
		// randomly choose one of the three triplet 3 or less hit rhythms.
		triplet160 = [[triplet160Freq1, triplet160Dur1], [triplet160Freq2, triplet160Dur2], [triplet160Freq3, triplet160Dur3]].choose;




		^super.newCopyArgs(straight120Freq1, straight120Dur1, straight120Freq2, straight120Dur2, straight120Freq3, straight120Dur3, straight120, straightOff120Freq1, straightOff120Dur1, straightOff120Freq2, straightOff120Dur2, straightOff120Freq3, straightOff120Dur3, straightOff120, off120Freq1, off120Dur1, off120Freq2, off120Dur2, off120Freq3, off120Dur3, off120, triplet120Freq1, triplet120Dur1, triplet120Freq2, triplet120Dur2, triplet120Freq3, triplet120Dur3, triplet120, straight129Freq1, straight129Dur1, straight129Freq2, straight129Dur2, straight129Freq3, straight129Dur3, straight129, straightOff129Freq1, straightOff129Dur1, straightOff129Freq2, straightOff129Dur2, straightOff129Freq3, straightOff129Dur3, straightOff129, off129Freq1, off129Dur1, off129Freq2, off129Dur2, off129Freq3, off129Dur3, off129, triplet129Freq1, triplet129Dur1, triplet129Freq2, triplet129Dur2, triplet129Freq3, triplet129Dur3, triplet129, straight130Freq1, straight130Dur1, straight130Freq2, straight130Dur2, straight130Freq3, straight130Dur3, straight130, straightOff130Freq1, straightOff130Dur1, straightOff130Freq2, straightOff130Dur2, straightOff130Freq3, straightOff130Dur3, straightOff130, off130Freq1, off130Dur1, off130Freq2, off130Dur2, off130Freq3, off130Dur3, off130, triplet130Freq1, triplet130Dur1, triplet130Freq2, triplet130Dur2, triplet130Freq3, triplet130Dur3, triplet130, straight140Freq1, straight140Dur1, straight140Freq2, straight140Dur2, straight140Freq3, straight140Dur3, straight140, straightOff140Freq1, straightOff140Dur1, straightOff140Freq2, straightOff140Dur2, straightOff140Freq3, straightOff140Dur3, straightOff140, off140Freq1, off140Dur1, off140Freq2, off140Dur2, off140Freq3, off140Dur3, off140, triplet140Freq1, triplet140Dur1, triplet140Freq2, triplet140Dur2, triplet140Freq3, triplet140Dur3, triplet140, straight160Freq1, straight160Dur1, straight160Freq2, straight160Dur2, straight160Freq3, straight160Dur3, straight160, straightOff160Freq1, straightOff160Dur1, straightOff160Freq2, straightOff160Dur2, straightOff160Freq3, straightOff160Dur3, straightOff160, off160Freq1, off160Dur1, off160Freq2, off160Dur2, off160Freq3, off160Dur3, off160, triplet160Freq1, triplet160Dur1, triplet160Freq2, triplet160Dur2, triplet160Freq3, triplet160Dur3, triplet160);
	}

	// Getter methods for SBP <120:

	// Return straight 120:
	getStraight120 {
		^straight120.value;
	}

	// Return straightOff 120:
	getStraightOff120 {
		^straightOff120.value;
	}

	// Return off 120:
	getOff120 {
		^off120.value;
	}

	// Return triplet 120:
	getTriplet120 {
		^triplet120.value;
	}

	// Getter methods for SBP 120-129:

	// Return straight 129:
	getStraight129 {
		^straight129.value;
	}

	// Return straightOff 129:
	getStraightOff129 {
		^straightOff129.value;
	}

	// Return off 129:
	getOff129 {
		^off129.value;
	}

	// Return triplet 129:
	getTriplet129 {
		^triplet129.value;
	}

	// Getter methods for SBP 130-139:

	// Return straight 130:
	getStraight130 {
		^straight130.value;
	}

	// Return straightOff 130:
	getStraightOff130 {
		^straightOff130.value;
	}

	// Return off 130:
	getOff130 {
		^off130.value;
	}

	// Return triplet 130:
	getTriplet130 {
		^triplet130.value;
	}

	// Getter methods for SBP 140-159:

	// Return straight 140:
	getStraight140 {
		^straight140.value;
	}

	// Return straightOff 140:
	getStraightOff140 {
		^straightOff140.value;
	}

	// Return off 140:
	getOff140 {
		^off140.value;
	}

	// Return triplet 140:
	getTriplet140 {
		^triplet140.value;
	}

	// Getter methods for SBP >=160:

	// Return straight 160:
	getStraight160 {
		^straight160.value;
	}

	// Return straightOff 160:
	getStraightOff160 {
		^straightOff160.value;
	}

	// Return off 160:
	getOff160 {
		^off160.value;
	}

	// Return triplet 160:
	getTriplet160 {
		^triplet160.value;
	}

}
