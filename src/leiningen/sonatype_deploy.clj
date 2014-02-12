(ns leiningen.sonatype-deploy
  (:use [clojure.java.io :only [file output-stream]])
  (:import [java.util.jar Attributes$Name JarOutputStream Manifest]))

(defn- create-manifest
  "Creates a manifest for a fake JAR file."
  []
  (let [manifest (Manifest.)]
    (.put (.getMainAttributes manifest) Attributes$Name/MANIFEST_VERSION "1.0.0")
    manifest))

(defn- create-fake-jar
  "Creates a JAR file."
  [project jar-type]
  (let [filename (str (:name project) "-" (:version project) "-" jar-type ".jar")
        target   (file (:target-path project))
        f        (file target filename)]
    (.mkdirs target)
    (with-open [out (JarOutputStream. (output-stream f) (create-manifest))])
    f))

(defn- deploy-fake-jar
  "Creates a fake JAR file"
  [project jar-type]
  (create-fake-jar project jar-type))

(defn sonatype-deploy
  "I don't do a lot."
  [project & [repo]]
  (map (partial deploy-fake-jar project) ["javadoc" "sources"]))
