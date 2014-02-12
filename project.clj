(defproject lein-sonatype-deploy "0.1.0-SNAPSHOT"
  :description "Deploys the artifacts required by sonatype for staging repositories."
  :url "https://github.com/iPlantCollaborativeOpenSource/lein-sonatype-deploy/"
  :license {:name "BSD Standard License"
            :url "http://iplantcollaborative.org/sites/default/files/iPLANT-LICENSE.txt"}
  :scm {:connection "scm:git:git@github.com:iPlantCollaborativeOpenSource/lein-sonatype-deploy.git"
        :developerConnection "scm:git:git@github.com:iPlantCollaborativeOpenSource/lein-sonatype-deploy.git"
        :url "git@github.com:iPlantCollaborativeOpenSource/lein-sonatype-deploy.git"}
  :pom-addition [:developers
                 [:developer
                  [:url "https://github.com/orgs/iPlantCollaborativeOpenSource/teams/iplant-devs"]]]
  :repositories [["sonatype-nexus-snapshots"
                  {:url "https://oss.sonatype.org/content/repositories/snapshots"}]]
  :deploy-repositories [["sonatype-nexus-staging"
                         {:url "https://oss.sonatype.org/service/local/staging/deploy/maven2/"}]]
  :eval-in-leiningen true)
