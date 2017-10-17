package de.consol.openshift

/**
 * @author: Oliver Weise
 * @since: 2017-10-17
 */
class Tasks {

    def Map config;
    def script;
    def String prefix;

    def Tasks(script, config) {
        this.config = config
        this.script = script
        this.prefix = "--server=${->config.openshift_url} --token=${->config.sa_token} " +
            "--insecure-skip-tls-verify=${-> config.no_tls ?: 'false'}"
    }

    def stageBuild(from ,to) {
        script.sh "oc ${prefix} tag ${from} ${to}"
    }

}
