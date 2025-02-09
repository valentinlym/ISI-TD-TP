/*
    Typst v.0.12.0
    author https://github.com/valentinlym
*/
#import "src/components/template.typ": *
#import "@preview/fletcher:0.5.3" as fletcher: node, edge

#show: project.with(
  title: "Cours : Ingénierie des systèmes interactifs",
  authors: (
    (name: "Valentin\u{a0}Leclair"),
  ),
  class: "KINX8AD1 Ingénierie des systèmes interactifs"
)

#show raw: set text(font: "Cascadia Mono")
#show raw.where(block: false, lang: none): box.with(fill: luma(240),
  inset: (x: 3pt, y: 0pt),
  outset: (y: 3pt),
  radius: 2pt,
  stroke: .03em,
)

#show raw.where(lang: "java"): box.with(
  inset: (x: 3pt, y: 0pt),
  outset: (y: 3pt),
  radius: 2pt,
)
#set table(
  stroke: none,
  fill: (x, y) =>
    if x == 0 or y == 0 { gray.transparentize(90%) },
  inset: (right: 1.5em),
)

#let Interdit = table.cell(
  fill: red.lighten(85%),
)[Interdit]

= Conception d'un système interactif
+ Liste des événements
+ Liste des actions
+ Matrice d'états/événements
+ Event-handlers
== Exemple de cours

#grid(columns: (1fr, 1fr), inset: 1em,
  [1) Système simple :],
  [- $E={E_1 ,E_2 ,E_3, E_4}, s_0=E_1$
  - $"Ev"={"Ev"_1,"Ev"_2},$
  - $A={A_1 ,A_2 ,A_3, A_4},$],
  [- $f: "E" times "Ev" -> "A"\
  f(E_1, "Ev"_1)=A_1\
  f(E_2, "Ev"_1)=f(E_3,"Ev"_1)=A_2\
  f(E_4, "Ev"_2)=f(E_3,"Ev"_2)=A_3\
  f(E_2, "Ev"_2)=A_4$],
  [- $g: E times "Ev" -> E,\
  g(E_1,"Ev"_1)=g(E_3,"Ev"_2)=E_2\
  g(E_2,"Ev"_1)=g(E_4,"Ev"_2)=E_3\
  g(E_3,"Ev"_1)=E_4\
  g(E_2,"Ev"_2)=E_1$
  ]
)

#figure(
 fletcher.diagram(
    node-stroke: .08em,
    spacing: 4em,

    // Start
    node((-1,-.5), radius: .2em, fill: black),
    edge((-1,-.5), (0,0), "-|>", bend: 35deg), 
    // edge((-1,-.5), (0,0), "-|>", $("/")/(#raw("init()"))$, bend: 45deg), 

    // E1
    node((0,0), $"E1"$, radius: 2em),
    edge($("Ev1/")/()$, "-|>"),

    // E2
    node((1,0), $"E2"$, radius: 2em),
    edge($("Ev2/")/()$, "-|>"),

    // E3
    node((2,0), $"E3"$, radius: 2em),
    edge($("Ev3/")/()$, "-|>"),

    // E4
    node((3,0), $"E4"$, radius: 2em),
    edge((3, 0), (0, 0), $("Ev4/")/()$, bend: 35deg)
  )
)

#figure(
  table(columns: 5, inset: (x: 2em, y: 1em), stroke: 0.03em,
    [],[$"Ev1"$],[$"Ev2"$],[$"Ev3"$],[$"Ev4"$],
    [$"E1"$],[État "E1"],Interdit,Interdit,Interdit,
    [$"E2"$],Interdit,[État "E3"],Interdit,Interdit,
    [$"E3"$],Interdit,Interdit,[État "E4"],Interdit,
    [$"E4"$],Interdit,Interdit,Interdit,[État "E1"],
  )
)

#pagebreak()
= Exercices de TP

== Quatre boutons (_Reprise de l'exercice du cours_)

- *Événements :* (_4 boutons_) `cb1`, `cb2`, `cb3`, `cb4`
- *Actions :* $nothing$
- *Automate :* 

#figure(caption: [Automate 4 boutons],
 fletcher.diagram(
    node-stroke: .08em,
    spacing: 4em,

    // Start
    node((-1,-.5), radius: .2em, fill: black),
    edge((-1,-.5), (0,0), "-|>", bend: 35deg), 
    // edge((-1,-.5), (0,0), "-|>", $("/")/(#raw("init()"))$, bend: 45deg), 

    // E1
    node((0,0), $"E1"$, radius: 2em),
    edge($("cb1/")/()$, "-|>"),

    // E2
    node((1,0), $"E2"$, radius: 2em),
    edge((2,0),$("cb2/")/()$, "-|>"),

    // E3
    node((2,0), $"E3"$, radius: 2em),
    edge($("cb3/")/()$, "-|>"),

    // E4
    node((3,0), $"E4"$, radius: 2em),
    edge((0,0),$("cb4/")/()$, "-|>", bend: 35deg),

  )
)

#figure(caption: [Matrice 4 boutons],
  table(columns: 5, inset: (x: 2em, y: 1em), stroke: 0.03em,
    [],[`cb1`],[`cb2`],[`cb3`],[`cb4`],
    [$"E1"$],[État "E2"],Interdit,Interdit,Interdit,
    [$"E2"$],Interdit,[État "E3"],Interdit,Interdit,
    [$"E3"$],Interdit,Interdit,[État "E4"],Interdit,
    [$"E4"$],Interdit,Interdit,Interdit,[État "E1"],
  )
)
- *Code :* `FourButtons.java`

#figure(caption: [Capture d'écran de l'app FourButtons],
  image("img/FourBtn.png", width: 50%)
)

#colbreak()
== Quatre boutons deux à deux

- *Événements :* (_3 boutons_) `cb1`, `cb2`, `cb3`, `cb4`
- *Actions :* $nothing$
- *Automate :* 

#figure(caption: [Automate 4 boutons deux à deux],
 fletcher.diagram(
    node-stroke: .08em,
    spacing: 4em,

    // Start
    node((-1,-.5), radius: .2em, fill: black),
    edge((-1,-.5), (0,0), "-|>", bend: 35deg), 
    // edge((-1,-.5), (0,0), "-|>", $("/")/(#raw("init()"))$, bend: 45deg), 

    // E1
    node((0,0), $"E1"$, radius: 2em),
    edge($("cb1/")/()$, "-|>", label-side: center),
    edge((1,.5),$("cb2/")/()$, "-|>", label-side: center),

    // E2
    node((1,-.5), $"E2"$, radius: 2em),
    edge((1,-.5),$("cb1/")/()$, "-|>", label-side: center, bend: 130deg),
    edge((2,0),$("cb2/")/()$, "-|>", label-side: center),

    // E3
    node((1,.5), $"E3"$, radius: 2em),
    edge((1,.5),$("cb2/")/()$, "-|>", label-side: center, bend: -130deg),
    edge((2,0), $("cb1/")/()$, "-|>", label-side: center),

    // E4
    node((2,0), $"E4"$, radius: 2em),
    edge((3,-.5),$("cb3/")/()$, "-|>", label-side: center),
    edge((3,.5),$("cb4/")/()$, "-|>", label-side: center),

    // E5
    node((3,-.5), $"E5"$, radius: 2em),
    edge((0,0),$("cb4/")/()$, "-|>", label-side: center, bend: -65deg),

    // E6
    node((3,.5), $"E6"$, radius: 2em),
    edge((0,0),$("cb3/")/()$, "-|>", label-side: center, bend: 65deg),

  )
)

#figure(caption: [Matrice 4 boutons deux à deux],
  table(columns: 5, inset: (x: 2em, y: 1em), stroke: 0.03em,
    [],[`cb1`],[`cb2`],[`cb3`],[`cb4`],
    [$"E1"$],[État "E2"],[État "E3"],Interdit,Interdit,
    [$"E2"$],[État "E2"],[État "E4"],Interdit,Interdit,
    [$"E3"$],[État "E4"],[État "E3"],Interdit,Interdit,
    [$"E4"$],Interdit,Interdit,[État "E5"],[État "E6"],
    [$"E5"$],Interdit,Interdit,[État "E5"],[État "E1"],
    [$"E6"$],Interdit,Interdit,[État "E1"],[État "E6"],
  )
)
- *Code :* `FourButtons2.java`

#figure(caption: [Capture d'écran de l'app FourButtons 2],
  image("img/FourBtn2.png", width: 25%)
)

#colbreak()
== Compteur

- *Événements :* 
  - (_3 boutons_) `cbStart`, `cbStop`, `cb+1`
- *Actions :* `init()`, `A1`, `A2`
- *Automate :* 

#figure(caption: [Automate compteur],
 fletcher.diagram(
    node-stroke: .08em,
    spacing: 4em,

    // Start
    node((-1,-.5), radius: .2em, fill: black),
    edge((-1,-.5), (0,0), "-|>", $("/")/(#raw("init()"))$, bend: 35deg), 
    // edge((-1,-.5), (0,0), "-|>", $("/")/(#raw("init()"))$, bend: 45deg), 

    // E1
    node((0,0), $"E1"$, radius: 2em),
    edge($(#raw("cbStart")"/")/(#raw("ini()"))$, "-|>"),

    // E2
    node((1,0), $"E2"$, radius: 2em),
    edge((0,0),$(#raw("cbStop")"/"n==3)/(#raw("A2"))$, "-|>", bend: 45deg),
    edge((1,0),$(#raw("cbStart")"/"n<3)/(#raw("A1"))$, "-|>", label-side: center, bend: 
    130deg),
  )
)

#figure(caption: [Matrice compteur],
  table(columns: 4, inset: (x: 2em, y: 1em), stroke: 0.03em,
    [],[`cbStart`],[`cbStop`],[`cb+1`],
    [$"E1"$],[`init()` \ État "E2"],Interdit,Interdit,
    [$"E2"$],Interdit,[`A2` \ État "E4"],[`A1` \  État "E2"],
  )
)
- *Code :* `Counter.java`

#figure(caption: [Capture d'écran de l'app Counter],
  image("img/Counter.png", width: 50%)
)

#colbreak()
== Compteur simple (avec timer)

- *Événements :* 
  - (_3 boutons_) `cbStart`, `cbStop`
  - (_1 Timer_) `Ttick`
- *Actions :* `init()`, `A1`, `A2`
- *Automate :* 

#figure(caption: [Automate compteur],
 fletcher.diagram(
    node-stroke: .08em,
    spacing: 4em,

    // Start
    node((-1,-.5), radius: .2em, fill: black),
    edge((-1,-.5), (0,0), "-|>", $("/")/(#raw("init()"))$, bend: 35deg), 
    // edge((-1,-.5), (0,0), "-|>", $("/")/(#raw("init()"))$, bend: 45deg), 

    // E1
    node((0,0), $"Start"$, radius: 2em),
    edge($(#raw("cbStart")"/")/(#raw("ini()"))$, "-|>"),

    // E2
    node((1,0), $"Stop"$, radius: 2em),
    edge((0,0),$(#raw("cbStop")"/"n==30000)/(#raw("A2"))$, "-|>", bend: 45deg),
    edge((1,0),$(#raw("Ttick")"/"n<30000)/(#raw("A1"))$, "-|>", label-side: center, bend: 
    130deg),
  )
)

#figure(caption: [Matrice compteur],
  table(columns: 4, inset: (x: 2em, y: 1em), stroke: 0.03em,
    [],[`cbStart`],[`cbStop`],[`Ttick`],
    [$"Start"$],[`init()` \ État "Stop"],Interdit,Interdit,
    [$"Stop"$],Interdit,[`A2` \ État "Start"],[`A1` \  État "Stop"],
  )
)
- *Code :* `CounterSimple.java`


#figure(caption: [Capture d'écran de l'app Counter Simple],
  image("img/CounterSimple.png", width: 50%)
)

#pagebreak()
== Compteur avancé

- *Événements :* 
  - (_3 boutons_) `cbStart`, `cbRecule`, `cbAvance`, `cbStop`
  - (_2 Timer_) `timerAvanceActive`, `timerReculeActive`
- *Actions :* `init()`, `A1`, `A2`
- *Automate :* 

#figure(caption: [Automate compteur avancé],
 fletcher.diagram(
    node-stroke: .08em,
    spacing: 4em,

    // Start
    node((-1,-.5), radius: .2em, fill: black),
    edge((-1,-.5), (0,0), "-|>", $("/")/(#raw("init()"))$, bend: 35deg), 
    // edge((-1,-.5), (0,0), "-|>", $("/")/(#raw("init()"))$, bend: 45deg), 

    // E1
    node((0,0), $"E1"$, radius: 2em),
    edge($(#raw("cbStart")"/")/(#raw("ini()"))$, "-|>", bend: 20deg),

    // E2
    node((1,0), $"E2"$, radius: 2em),
    edge((0,0),$(#raw("cbStop")"/"n==30000)/(#raw("A2"))$, "-|>", bend: 35deg),
    edge((1,0),$(#raw("timerAvanceActive")"/")/(#raw("A1"))$, "-|>", label-side: center, bend: 
    130deg),
    edge((2,0),$(#raw("cbRecule")"/")/()$, "-|>", bend: 20deg),

    // E3
    node((2,0), $"E3"$, radius: 2em),
    edge((1,0),$(#raw("cbAvance")"/")/()$, "-|>", bend: 35deg),
    edge((2,0),$(#raw("timerReculeActive")"/")/(#raw("A3"))$, "-|>", label-side: center, bend: 
    130deg),
    edge((0,0),$(#raw("cbStop")"/")/(#raw("A2"))$, "-|>", label-side: center, bend: 
    75deg),
  )
)

#figure(caption: [Matrice compteur],
  table(columns: 7, inset: (x: .25em, y: 1em), stroke: 0.03em,
    [],[`cbStart`], [`cbStop`], [`cbRecule`], [`cbAvance`], [`timerReculeActive`], [`timerAvanceActive`],
    [$"START"\ "E1"$],[`init()` \ État "E2"],Interdit,Interdit,Interdit,Interdit,Interdit,

    [$"RECULE_STOP"\ "E2"$],Interdit,[`A2` \ État "E1"],Interdit,[État "E3"],Interdit,[`A2` \ État "E2"],

    [$"AVANCE_STOP"\ "E3"$],Interdit,[`A2` \ État "E1"],[État "E2"],Interdit,[`A2` \ État "E3"],Interdit,
  )
)
- *Code :* `CounterAdvenced.java`


#figure(caption: [Capture d'écran de l'app Counter Advenced],
  image("img/CounterAdvenced.png", width: 50%)
)