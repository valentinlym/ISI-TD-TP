# ISI TD & TP - M1 Informatique

Ce répertoire permet de rédiger un rapport avec `Typst` de manière collaborative grâce à `git`. `Typst` est un langage permettant de rédiger des `pdf` à la manière de [`LaTeX`] ([voir la documentation officielle (en anglais)][doc_typst]).

## Configurer Typst

Il y a deux manières d'utiliser `Typst` :

-   Via l'éditeur en ligne [sur leur site officiel >][app_typst]
-   En local, dans un environnement bien configuré. C'est la même chose que l'éditeur, _en plus d'une utilisation hors ligne_ :)

La fonction collaborative avec `git` est payante sur l'éditeur en ligne. Nous privilégions donc la seconde option. De plus, la mise en place de `Typst` est assez simple.

### Installer Typst (CLI) avec Visual Studio Code

-   Sous macOS avec Homebrew : `brew install typst`
-   Sous Windows : `winget install --id Typst.Typst`
-   Sous distribution GNU/Linux : [voir sur Repology][install_linux]

(`Typst` étant développé avec [🦀 Rust][rust], il est possible de l'installer avec `cargo`. [Si cela vous tente >][github_typst])

Tester l'installation : `typst --version`

Pour finir, ouvrez votre Visual Studio Code et ajoutez cette extension :

-   [Tinymist Typst][tinymist_typst] de Myriad Dreamin

Effectuez un `>Developer: Reload Window` pour s'assurer de la bonne installation de l'extensions. Si tout fonctionne bien, vous êtes en mesure de prévisualiser un fichier `.typ` avec un `>Typst Preview: Preview current file`. Et voilà ! Un magnifique PDF apparaît, et cerise sur le gâteau, vous pouvez cliquer dessus pour retrouver l'endroit associé dans le fichier `.typ` ƪ(˘⌣˘)ʃ

[github_typst]: https://github.com/typst/typst?tab=readme-ov-file#installation
[doc_typst]: https://typst.app/docs/
[app_typst]: https://typst.app/
[`LaTeX`]: https://fr.wikipedia.org/wiki/LaTeX
[rust]: https://www.rust-lang.org/
[install_linux]: https://repology.org/project/typst/versions
[tinymist_typst]: https://marketplace.visualstudio.com/items?itemName=myriad-dreamin.tinymist
