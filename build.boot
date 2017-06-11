(set-env! :source-paths   #{"src"}
          :resource-paths #{"resources"}
          :dependencies   '[[org.clojure/clojurescript "1.9.562"]
                            [pandeiro/boot-http "0.8.3"]
                            [quil "2.6.0"]

                            [org.clojure/clojure "1.9.0-alpha17" :scope "test"]
                            [adzerk/boot-cljs "2.0.0" :scope "test"]
                            [adzerk/boot-cljs-repl "0.3.3" :scope "test"]
                            [adzerk/boot-reload "0.5.1" :scope "test"]
                            [com.cemerick/piggieback "0.2.1" :scope "test"]
                            [org.clojure/tools.nrepl "0.2.12" :scope "test"]
                            [weasel "0.7.0" :scope "test"]]
          :exclusions     '[org.clojure/clojure
                            org.clojure/clojurescript])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
         '[adzerk.boot-reload :refer [reload]]
         '[pandeiro.boot-http :refer [serve]])

(task-options!
 reload {:asset-path "public"}
 serve  {:resource-root "public"}
 target {:dir #{"target"}})

(deftask build
  "Compile sketch and bundle assets."
  []
  (comp
   (cljs :optimizations :advanced
         :compiler-options {:output-wrapper true})
   (sift :include #{#"\.out/" #"\.edn$"}
         :invert true)
   (target)))

(deftask run
  "Build and serve sketch locally."
  []
  (comp
   (build)
   (serve)
   (wait)))

(deftask dev
  "Start up interactive develepment environment."
  []
  (comp
   (serve)
   (watch)
   (cljs-repl)
   (reload :on-jsload 'chronograph.sketch/reset)
   (cljs :optimizations :none
         :source-map true
         :compiler-options {:preloads '[chronograph.dev]})))
