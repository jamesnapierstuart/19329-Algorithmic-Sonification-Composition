/*

HeartRiskPiece Class,
The core structure of the algorithmic composition.
Utilizes the human class, which in turn makes use if the drum and synth pattern classes.
Has the playPiece method which takes amount of males and females wanted.
(c) 2013-2014, Candidate Number 19329

*/

HeartRiskPiece {


	var humanArray, synthArray, setUpSynths, riskN, test, m, repeat, randN, clock, maleP, malePattern, maleDelay, maleReverb, maleDistortion, oldFemaleP, oldFPattern, oldFDelay, oldFReverb, veryOldFemaleP, veryOldFPattern, veryOldFDelay, veryOldFReverb, youngFemaleP, youngFPattern, youngFDelay, youngFReverb, genderCheck, intro, increase, increaseN, maleAmount, femaleAmount, genderN, scrambleN, setHumans, secondAmount, risk1, risk2, dead, s;


	*new {

		^super.newCopyArgs();
	}

	// PlayPiece method plays the sttructed sonification of humans.
	// Takes args amount of males and amount of females.
	playPiece { arg males = 0, females = 0;


		// Boot server
		s = Server.local;
		s.boot;
		s.latency = 0.5;

		// Set the tempo to be 130bpm (130/60)
		clock = TempoClock(2.1666666666667);
		//TempoClock.default.tempo = 2.1666666666667;

		// Set the male and female amounts to the arguments:
		maleAmount = males;
		femaleAmount = females;

		// Human array number and pattern repeat value
		m = 0;
		repeat =(maleAmount+femaleAmount)/2;

		setUpSynths = {

			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			// Effects Units

			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			// reverb
			SynthDef(\reverbJ, {arg amp = 0.5, effectLevel = 0.5;

				var input, effect;

				input = In.ar(16, 2);

				effect = FreeVerb.ar(input, 2, 1) * effectLevel;

				Out.ar(0, effect);

			}).add;

			// delay
			SynthDef(\delayJ, {arg delaytime=0.5, amp = 0.5;

				var input, effect;

				input=In.ar(18, 2);

				effect= BufDelayN.ar(input, 1, delaytime) * amp;

				Out.ar(0, effect);
			}).add;


			// Distortion sound adapted from this code reference:
			// http://new-supercollider-mailing-lists-forums-use-these.2681727.n2.nabble.com/Distortion-effect-td5173262.html
			SynthDef(\distortionJ, {arg amount = 0.7, amp = 0.5;

				var level, k, effect, input;


				input= In.ar(20, 1);

				k = 2 * amount / (1- amount);

				effect = ((1+k) * input / (1 + (k * input.abs))) *amp;

				Out.ar(0, effect);
			}).add;


			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			// Female SynthDefs below:

			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


			// Synth chord 1:
			SynthDef(\chrd1J, {arg freq = 440, harmony1 = 440, harmony2 = 440, harmony3 = 440, harmony4 = 440, oscType = 2, filtType= 1, envType = 1, lfoType = 0, lforate = 10, cutofffreq = 200, startfreq = 60, endfreq = 10000, filtdur = 2, rq = 0.3, attack = 0.6, decay = 3, sustain = 0, release = 3, envlevel = 1, curve = -6, start = 1.0, end = 0, dura = 1.0,  gate = 1, amp = 0.05;

				var oscArray, envArray, filtArray, lfoArray, sound, env, root, lfo, endi, outi;

				lfoArray = [
					SinOsc.ar(lforate),
					Saw.ar(lforate),
					Pulse.ar(lforate)];

				lfo = (Select.ar(lfoType, lfoArray));

				oscArray = [
					Mix(SinOsc.ar([freq, (freq+harmony1), (freq+harmony2), (freq+harmony3), (freq+harmony4)], 0, 0.2)),
					Mix(Saw.ar([([0.995, 1, 1.02, 1.5] * freq), ([0.995, 1, 1.02, 1.5] * (freq+harmony1)), ([0.995, 1, 1.02, 1.5] *(freq+harmony2)), ([0.995, 1, 1.02, 1.5] * (freq+harmony3)), ([0.995, 1, 1.02, 1.5] * (freq+harmony4)),], 0.2)),
					Mix(Pulse.ar([([0.995, 1, 1.02, 1.5] * freq), ([0.995, 1, 1.02, 1.5] * (freq+harmony1)), ([0.995, 1, 1.02, 1.5] *(freq+harmony2)), ([0.995, 1, 1.02, 1.5] * (freq+harmony3)), ([0.995, 1, 1.02, 1.5] * (freq+harmony4)),], 0.2, 0.2)),
					Mix(LFTri.ar([([0.995, 1, 1.02, 1.5] * freq), ([0.995, 1, 1.02, 1.5] * (freq+harmony1)), ([0.995, 1, 1.02, 1.5] *(freq+harmony2)), ([0.995, 1, 1.02, 1.5] * (freq+harmony3)), ([0.995, 1, 1.02, 1.5] * (freq+harmony4)),], 0.2, 0.2))];

				filtArray = [
					Select.ar(oscType, oscArray), // Off
					RLPF.ar(Select.ar(oscType, oscArray), Line.kr(startfreq, endfreq, filtdur), rq),
					RHPF.ar(Select.ar(oscType, oscArray), Line.kr(startfreq, endfreq, filtdur), rq),
					MoogFF.ar(Select.ar(oscType, oscArray),  Line.kr(startfreq, endfreq, filtdur), rq)];


				envArray = [EnvGen.kr(Env.adsr(attack, decay, sustain, release), gate, doneAction:2),
					EnvGen.kr(Env.perc(attack, release, envlevel, curve), gate, doneAction:2),
					Line.kr(start, end, dura)];

				env = Select.kr(envType, envArray);
				sound = (Select.ar(filtType, filtArray)) * lfo;


				Out.ar(0, Pan2.ar(sound*env*amp));

			}).add;


			// Synth chord 2:
			SynthDef(\chrd2J, {arg freq = 440, harmony1 = 440, harmony2 = 440, oscType = 3, filtChoice = 0, filtType= 1, lfoType = 0, lforate = 5, cutofffreq = 200, startfreq = 60, endfreq = 80000, filtdur = 10, rq = 0.3, attack = 0.6, decay = 2.1, sustain = 0, release = 1, envType = 1, envlevel = 1, curve = -6, start = 1.0, end = 0, dura = 1.0,  gate = 1, amp = 0.1;

				var oscArray, envArray, filtArray, filtArray2, lfoArray, sound, env, root, lfo, out, abc;

				lfoArray = [
					SinOsc.ar(lforate)];

				lfo = (Select.ar(lfoType, lfoArray));

				oscArray = [
					Mix(SinOsc.ar([freq, (freq+harmony1), (freq+harmony2)], 0, 0.2)),
					Mix(Saw.ar([([0.995, 1, 1.02, 1.5] * freq), ([0.995, 1, 1.02, 1.5] * (freq+harmony1)), ([0.995, 1, 1.02, 1.5] *(freq+harmony2))], 0.2)),
					Mix(Pulse.ar([([0.995, 1, 1.02, 1.5] * freq), ([0.995, 1, 1.02, 1.5] * (freq+harmony1)), ([0.995, 1, 1.02, 1.5] *(freq+harmony2))], 0.2, 0.2)),
					Mix(LFTri.ar([([0.995, 1, 1.02, 1.5] * freq), ([0.995, 1, 1.02, 1.5] * (freq+harmony1)), ([0.995, 1, 1.02, 1.5] *(freq+harmony2))], 0.2, 0.2))];

				filtArray = [
					Select.ar(oscType, oscArray), // Off
					RLPF.ar(Select.ar(oscType, oscArray), lfo.range(100, 10000),lfo.range(0.1, 2.0)),
					RHPF.ar(Select.ar(oscType, oscArray), lfo.range(100, 10000),lfo.range(0.1, 2.0)),
					MoogFF.ar(Select.ar(oscType, oscArray),lfo.range(100, 10000),lfo.range(0.1, 2.0))];


				envArray = [EnvGen.kr(Env.adsr(attack, decay, sustain, release), gate, doneAction:2),
					EnvGen.kr(Env.perc(attack, release, envlevel, curve), gate, doneAction:2),
					Line.kr(start, end, dura)];

				env = Select.kr(envType, envArray);
				sound = (Select.ar(filtType, filtArray));

				abc = sound * env;

				out = RLPF.ar(abc, Line.kr(startfreq, endfreq, filtdur), rq);
				Out.ar(0, Pan2.ar(out*amp));

			}).add;


			// Synth 3 Solo line:
			SynthDef(\solo1J, {arg freq = 440, oscType = 1, filtType = 1, envType = 0, cutofffreq = 500, rq = 0.3, attack = 0.1, decay = 3, sustain = 0, release = 3, envlevel = 1, curve = -6, start = 1.0, end = 0, dura = 0.5,  gate = 1, amp = 0.1, lforate = 1;

				var oscArray, envArray, filtArray, lfoArray, sound, env, root, lfo, endi, outi;

				lfo = SinOsc.ar(lforate);

				oscArray = [
					Mix(SinOsc.ar([([0.995, 1, 1.02, 1.5] * freq),], 0, 0.2)),
					Mix(Saw.ar([([0.995, 1, 1.02, 1.5] * freq),], 0.2)),
					Mix(Pulse.ar([([0.995, 1, 1.02, 1.5] * freq),], 0.2, 0.2)),
					Mix(LFTri.ar([([0.995, 1, 1.02, 1.5] * freq),], 0.2, 0.2))];

				filtArray = [
					Select.ar(oscType, oscArray), // Off
					RLPF.ar(Select.ar(oscType, oscArray), cutofffreq, rq),
					RHPF.ar(Select.ar(oscType, oscArray), cutofffreq, rq),
					MoogFF.ar(Select.ar(oscType, oscArray),  cutofffreq, rq)];


				envArray = [EnvGen.kr(Env.adsr(attack, decay, sustain, release), gate, doneAction:2),
					EnvGen.kr(Env.perc(attack, release, envlevel, curve), gate, doneAction:2),
					Line.kr(start, end, dura)];

				env = Select.kr(envType, envArray) * lfo;
				sound = (Select.ar(filtType, filtArray));


				Out.ar(0, Pan2.ar(sound*env*amp));

			}).add;


			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			// Male SynthDefs below:

			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			// Hihat 1:
			SynthDef(\hat1J, { arg amp = 0.1, attack = 0.01, level =1;

				var hatosc, hatenv, hatnoise, hatnoise2, hatoutput;

				hatnoise = {LPF.ar(WhiteNoise.ar(), 5000)};
				hatnoise2 = {LPF.ar(PinkNoise.ar(), 9000)};

				hatosc = {HPF.ar(hatnoise + hatnoise2, 8000)};
				hatenv = EnvGen.kr(Env.perc(attack,  0.1, level, -6), 1,  doneAction:2);

				hatoutput = (hatosc * hatenv);

				Out.ar(0,
					Pan2.ar(hatoutput) * amp
				)

			}).add;


			// Hihat 2:
			SynthDef(\hat2J, { arg amp = 0.1, attack = 0.01, level = 1;

				var hatosc, hatenv, hatnoise, hatnoise2, hatoutput;

				hatnoise = {LPF.ar(WhiteNoise.ar(), 8000)};
				hatnoise2 = {LPF.ar(PinkNoise.ar(), 9000)};

				hatosc = {HPF.ar(hatnoise + hatnoise2, 8000)};
				hatenv = EnvGen.kr(Env.perc(attack,  0.1, level, -6), 1,  doneAction:2);

				hatoutput = (hatosc * hatenv);

				Out.ar(0,
					Pan2.ar(hatoutput) * amp
				)

			}).add;


			// Kick:
			SynthDef(\kickJ,{
				arg freq = 240, amp=0.1, attack = 0.01, level = 1;
				var sound, env, sub, subenv, subout, click, clickenv, clickout;


				sub = SinOsc.ar(freq/4);
				subenv = EnvGen.kr(Env.adsr(attack, 0.2, 0, 1, 1), 1, level, doneAction:0.2);
				subout = (sub * subenv);

				env = EnvGen.kr(Env.adsr(attack, 0.2,  0, 1, 1), 1, level, doneAction:2);
				sound = SinOsc.ar(Line.kr(freq,60,0.05))*env;


				Out.ar(0, Pan2.ar(sound + subout)*amp)

			}).add;

			// Cowbell:
			// sound adapted from
			//http://sccode.org/1-4Ql
			SynthDef(\cowBellJ, {arg amp = 0.1, level = 1, attack = 0.01;

				var env, cow, cowOut;

				env = EnvGen.ar(Env([attack,1,0.1,0],[(attack/2), 0.015,0.283]), 1, level, doneAction:2);

				cow = BPF.ar(Mix(Pulse.ar(587.3*[1, 1.5074])), 2640,0.9);

				cowOut = Pan2.ar(cow*env);

				Out.ar(0, (cowOut*amp));

			}).add;



			// Tom:
			SynthDef(\tomJ, {arg amp = 0.1, level = 0.5, freq=430, attack = 0.001;

				var env4, tom, tomOut;


				env4 = EnvGen.kr(Env.perc(attack, 0.6, level, -5), 1, doneAction:2);

				// freq = 430
				tom = SinOsc.ar(freq);
				tomOut = Pan2.ar(tom*env4);

				Out.ar(0, FreeVerb.ar((tomOut* amp), 0.33, 0.5));

			}).add;


			// Snare:
			SynthDef(\snareJ, { arg amp = 0.01, attack = 0.01, level = 1;

				var snare, snareenv, snareout, click, clickenv, clickout, claposc, clapenv, clapnoise, clapoutput, clap, snare2osc, snare2env, snare2noise, snare2noise2, snare2output;


				snare = SinOsc.ar(240);
				snareenv = EnvGen.kr(Env.perc(attack, 0.275, 2, -6), 1, level, doneAction:0.275);
				snareout = (snare * snareenv);

				click = {LPF.ar(WhiteNoise.ar(1),1200)};
				clickenv = {Line.ar(1, 0, 0.002) * level};
				clickout = (click * clickenv);

				clapnoise = {BPF.ar(LPF.ar(WhiteNoise.ar(1),7500),1500)};
				clapenv = {Line.ar(1, 0, 0.1, doneAction: 2)*level};

				clapoutput = {Mix.arFill(7, {arg i;
					EnvGen.ar(
						Env.new(
							[0,0,1,0],
							[0.01 * i,0,0.04]
						)
					) * clapnoise
					}
				)};


				snare2noise = {LPF.ar(WhiteNoise.ar(), 8000)};
				snare2noise2 = {LPF.ar(PinkNoise.ar(), 5000)};

				snare2osc = {HPF.ar(snare2noise + snare2noise2, 80)};
				snare2env = EnvGen.kr(Env.perc(attack,  0.2, 2, -6), 1, level,  doneAction:2);

				snare2output = (snare2osc * snare2env);

				clap = clapoutput * clapenv;

				Out.ar(0, Pan2.ar(clap + snareout + clickout + snare2output) * amp);

			}).add;

			// Death Synth:

			SynthDef(\deathJ, {arg freq = 440, amp = 0.01, gate = 1, sustains = 1;

				var sound, env, out, filter;

				sound = SinOsc.ar(freq) + LFTri.ar(freq) + Saw.ar(freq);

				env = EnvGen.kr(Env.adsr(0.01, 0.5, sustains, 1), gate, doneAction:2);

				filter = HPF.ar(sound, 1000);

				out = filter * env;


				Out.ar(0, Pan2.ar(out*amp));

			}).add;



		};

		// Set up the synth defs:
		setUpSynths.value;

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Initialising humans (creation of humans)

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		// New Array of humans
		humanArray = Array.fill((maleAmount+femaleAmount), {
			Human();
		});

		// Set the gender of the humans first male, then female, then scramble the array:
		genderN = 0;
		maleAmount.do{
			humanArray[genderN].setGender("male");
			genderN = genderN + 1;
		};
		femaleAmount.do{
			humanArray[genderN].setGender("female");
			genderN= genderN + 1;
		};

		humanArray = humanArray.scramble;

		// Calculate the synth and risk for every human:
		riskN = 0;
		(maleAmount+femaleAmount).do{
			humanArray[riskN].calculateRisk;
			riskN = riskN + 1;
		};

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Male and Female Patterns:

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Male Pattern:
		maleP = {

			malePattern =

			Pbind(
				\instrument, humanArray[m].getSynth,
				\attack, humanArray[m].getAttack,
				\level, Pseq ([humanArray[m].getDrumPattern[0]]),
				\dur, Pseq ([humanArray[m].getDrumPattern[1]]),
			);

			maleDelay = Pfx(malePattern, \delayJ, \delaytime, humanArray[m].getDelay);
			maleReverb = Pfx(maleDelay, \reverbJ, \amp, humanArray[m].getReverb);
			maleDistortion = Pfx(maleReverb, \distortionJ, \amp, humanArray[m].getDistortion);
			s.bind { Pseq([maleDistortion], repeat).play(clock) };


		};

		// Young Female Pattern:
		youngFemaleP = {

			youngFPattern = Pbind(
				[\midinote, \dur], Pseq([humanArray[m].getSynthPattern]),
				\instrument, humanArray[m].getSynth,
				\oscType, humanArray[m].getOsc,
				\envType, 1,
				\lforate, humanArray[m].getLforate,
				\amp, 0.1,

			);

			youngFDelay = Pfx(youngFPattern, \delayJ, \delaytime, humanArray[m].getDelay);
			youngFReverb = Pfx(youngFDelay, \reverbJ, \amp, humanArray[m].getReverb);
			s.bind { Pseq([youngFReverb], repeat).play(clock) };

		};

		// Old female pattern:
		oldFemaleP = {

			oldFPattern = Pbind(
				[\midinote, \dur], Pseq([humanArray[m].getSynthPattern[0]],),
				\instrument, humanArray[m].getSynth,
				\harmony1, Pseq([humanArray[m].getSynthPattern[1]],),
				\harmony2, Pseq([humanArray[m].getSynthPattern[2]], ),
				\harmony3, Pseq([humanArray[m].getSynthPattern[3]],),
				\harmony4, Pseq([humanArray[m].getSynthPattern[4]]),
				\oscType, humanArray[m].getOsc,
				\envType, 1,
				\lforate, humanArray[m].getLforate,
				\amp, 0.1,

			);

			oldFDelay = Pfx(oldFPattern, \delayJ, \delaytime, humanArray[m].getDelay);
			oldFReverb = Pfx(oldFDelay, \reverbJ, \amp, humanArray[m].getReverb);
			s.bind { Pseq([oldFReverb], repeat).play(clock) };

		};

		// Very old female pattern:
		veryOldFemaleP = {

			veryOldFPattern = Pbind(
				[\midinote, \dur], Pseq([humanArray[m].getSynthPattern[0]]),
				\instrument, humanArray[m].getSynth,
				\harmony1, Pseq([humanArray[m].getSynthPattern[1]]),
				\harmony2, Pseq([humanArray[m].getSynthPattern[2]]),
				\oscType, humanArray[m].getOsc,
				\envType, 1,
				\lforate, humanArray[m].getLforate,
				\amp, 0.1,


			);

			veryOldFDelay = Pfx(veryOldFPattern, \delayJ, \delaytime, humanArray[m].getDelay);
			veryOldFReverb = Pfx(veryOldFDelay, \reverbJ, \amp, humanArray[m].getReverb);
			s.bind { Pseq([veryOldFReverb], repeat).play(clock) };

		};

		// Check gender and if necessary age of human, to select correct Pattern:
		genderCheck = {
			case
			{(humanArray[m].getGender == "male")}  {
				case
				{(humanArray[m].getAge < 80)}  {
					"Male".postln;
					maleP.value;
				}
				{(humanArray[m].getAge > 79)} {
					"This human has now died".postln;
					// Do the death pattern
					dead = Pbind(
						\instrument, \deathJ,
						\freq, 1020,
						\dur, Pseq([1.0, 1.0, 1.0, 1.0, 3.0],),
						\amp, 0.04,
					).play;

				}
			}

			{(humanArray[m].getGender == "female")}  {
				case
				{(humanArray[m].getAge < 45)} {
					"young female".postln;
					youngFemaleP.value;
				}

				{(humanArray[m].getAge > 44) && (humanArray[m].getAge < 65)} {
					"old female".postln;
					oldFemaleP.value;
				}

				{(humanArray[m].getAge > 64) && (humanArray[m].getAge < 80)} {
					"very old female".postln;
					veryOldFemaleP.value;
				}
				{(humanArray[m].getAge > 79)} {
					"This human has now died".postln;
					// Do the death pattern
					dead = Pbind(
						\instrument, \deathJ,
						\freq, 1020,
						\dur, Pseq([1.0, 1.0, 1.0, 1.0, 3.0],),
						\amp, 0.04,
					).play;

				}


			};

		};

		// Intro of piece:
		intro = {
			{
				"\nCycling through humans:".postln;
				// do this half the amount of the humans involved
				((maleAmount+femaleAmount)/2).do{
					genderCheck.value;
					m = m + 1;
					repeat = repeat - 1;
					7.5.wait;
					// has to .5 wait for the latency is 0.5

				}
			}.fork;

		};

		// Call intro function:
		intro.value;

		// Extension of intro:
		secondAmount = {
			clock.sched((((maleAmount+femaleAmount)/2)*16)+0.5,
				{
					// Change repeat to be only 2 for each human now
					repeat = (maleAmount+femaleAmount)/2;
					intro.value;
				};
			);
		};

		// Call extension of intro function:
		secondAmount.value;

		// vary tempo based upon risk assessment, higher the risk faster the tempo.
		risk1 = { arg i = 0;

			{
				m = 0;
				repeat = (maleAmount+femaleAmount)/2;


				((maleAmount+femaleAmount)).do{
					case
					{(humanArray[i].getTotalPoints < 0)} {
						clock = TempoClock(0.5);
						"".postln;
						"\n "+humanArray[i].getRisk.postln;
					}
					{(humanArray[i].getTotalPoints == 0).or(humanArray[i].getTotalPoints == 1).or(humanArray[i].getTotalPoints == 2).or(humanArray[i].getTotalPoints == 3).or(humanArray[i].getTotalPoints == 4)} {
						clock = TempoClock(1);
						"".postln;
						"\n "+humanArray[i].getRisk.postln;
					}
					{(humanArray[i].getTotalPoints == 5).or(humanArray[i].getTotalPoints == 6)} {
						clock = TempoClock(1);
						"".postln;
						"\n "+humanArray[i].getRisk.postln;
					}
					{(humanArray[i].getTotalPoints == 7)} {
						clock = TempoClock(2);
						"".postln;
						"\n "+humanArray[i].getRisk.postln;
					}
					{(humanArray[i].getTotalPoints == 8)} {
						clock = TempoClock(2);
						"".postln;
						"\n "+humanArray[i].getRisk.postln;
					}
					{(humanArray[i].getTotalPoints == 9)} {
						clock = TempoClock(2.1666666666667);
						"".postln;
						"\n "+humanArray[i].getRisk.postln;
					}
					{(humanArray[i].getTotalPoints == 10)} {
						clock = TempoClock(2.1666666666667);
						"".postln;
						"\n "+humanArray[i].getRisk.postln;
					}
					{(humanArray[i].getTotalPoints == 11)} {
						clock = TempoClock(3);
						"".postln;
						"\n "+humanArray[i].getRisk.postln;
					}
					{(humanArray[i].getTotalPoints == 12)} {
						clock = TempoClock(3);
						"".postln;
						"\n "+humanArray[i].getRisk.postln;
					}
					{(humanArray[i].getTotalPoints == 13)} {
						clock = TempoClock(4);
						"".postln;
						"\n "+humanArray[i].getRisk.postln;
					}
					{(humanArray[i].getTotalPoints == 14)} {
						clock = TempoClock(4);
						"".postln;
						"\n "+humanArray[i].getRisk.postln;
					}
					{(humanArray[i].getTotalPoints == 15)} {
						clock = TempoClock(5);
						"".postln;
						"\n "+humanArray[i].getRisk.postln;
					}
					{(humanArray[i].getTotalPoints == 16)} {
						clock = TempoClock(5);
						"".postln;
						"\n "+humanArray[i].getRisk.postln;
					}
					{(humanArray[i].getTotalPoints >= 17)} {
						clock = TempoClock(6);
						"".postln;
						"\n "+humanArray[i].getRisk.postln;
					};

					genderCheck.value;
					m = m+1;
					i = i+1;
					7.5.wait;
				}
			}.fork;
		};


		// Now put the risk function into another function for scheduling:
		risk2 = {


			clock.sched((((maleAmount+femaleAmount)/2)*32)+0.5,
				{
					risk1.value;
				};
			);
		};

		// Call the risk2 function:
		risk2.value;


		// Increase age and vary all human features (except gender)
		increase = { arg i = 0;

			clock.sched((((maleAmount+femaleAmount)/2)*68)+0.5,
				{
					(maleAmount+femaleAmount).do{
						// Increase the humans age and randomise features
						humanArray[i].setAge((humanArray[i].getAge+20));
						humanArray[i].setTc((191.rand+130));
						humanArray[i].setHdl((81.rand+20));
						humanArray[i].setSmokerStatus(([true, false].choose));
						humanArray[i].setSbp((111.rand+90));
						humanArray[i].setTreatment(([true, false].choose));
						humanArray[i].calculateRisk;
						i = i + 1;
					};

					"\nIncreasing age and varying human features, people change over time.".postln;
					// reset m and repeat
					m = 0;
					repeat =(maleAmount+femaleAmount)/2;
					clock = TempoClock(2.1666666666667);
					intro.value;
					secondAmount.value;
					risk2.value;
				};
			);
		};

		// Call the increase function:
		increase.value;

	}

}