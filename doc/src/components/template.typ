#let project(title: "Title", class: "", authors: (), lang: "fr", version: "v.0.1", body) = {
  show heading: set block(below: 1em)
  set text(weight: "regular", font: "New Computer Modern Sans")
  set document(author: authors.map(a => a.name), title: title)

  set page(
    margin: (x:1cm,y:1.75cm),
    header: grid(columns: (1fr, auto),
      [#title — #context here().page()],
      [#datetime.today().display("[day].[month].[year]") — #authors.at(0).name]
    ),
    footer: grid(columns: (1fr,auto),
      align(left+horizon)[#image("/src/img/logo_univ-tlse.svg", width: 30%)],align(right+horizon)[#class]
    ),
  )

  body
}