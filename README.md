# chronograph

Browser clock implemented in [Quil] that renders a mark for every *pars minuta
tertia* of the current minute.

[Quil]: http://quil.info

## Usage

The [Boot] build tool needs to be installed.

[Boot]: http://boot-clj.com
[ClojureScript]: https://clojurescript.org

### Build & Run

Build and serve the sketch locally with:

```sh
boot run
```

The sketch is now available at [localhost:3000](http://localhost:3000).

### Development

Start up the interactive development environment:

```sh
boot dev
```

Open [localhost:3000](http://localhost:3000) and all changes to the project
files will automatically be reflected in the browser.

Connect to the browser repl with [Fireplace]:

```vim
:Piggieback (adzerk.boot-cljs-repl/repl-env)
```

[Fireplace]: https://github.com/tpope/vim-fireplace

### Deploy

Build an optimized production bundle:

```sh
boot build
```

Serve the contents of `target/public/`:

```sh
boot serve -d target/public/ wait
```

---
Copyright © 2017 Tibor Claassen. Distributed under the MIT License.
