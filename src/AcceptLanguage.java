// Part 1
// In an HTTP request, the Accept-Language header describes the list of
// languages that the requester would like content to be returned in. The header
// takes the form of a comma-separated list of language tags. For example:
//   Accept-Language: en-US, fr-CA, fr-FR
// means that the reader would accept:
//   1. English as spoken in the United States (most preferred)
//   2. French as spoken in Canada
//   3. French as spoken in France (least preferred)
// We're writing a server that needs to return content in an acceptable language
// for the requester, and we want to make use of this header. Our server doesn't
// support every possible language that might be requested (yet!), but there is a
// set of languages that we do support. Write a function that receives two arguments:
// an Accept-Language header value as a string and a set of supported languages,
// and returns the list of language tags that will work for the request. The
// language tags should be returned in descending order of preference (the
// same order as they appeared in the header).
// In addition to writing this function, you should use tests to demonstrate that it's
// correct, either via an existing testing system or one you create.
// Examples:
// parse_accept_language(
//   "en-US, fr-CA, fr-FR",  # the client's Accept-Language header, a string
//   ["fr-FR", "en-US"]      # the server's supported languages, a set of strings
// )
// returns: ["en-US", "fr-FR"]

// parse_accept_language("fr-CA, fr-FR", ["en-US", "fr-FR"])
// returns: ["fr-FR"]

// parse_accept_language("en-US", ["en-US", "fr-CA"])
// returns: ["en-US"]

// Part 2
// Accept-Language headers will often also include a language tag that is not
// region-specific - for example, a tag of "en" means "any variant of English". Extend
// your function to support these language tags by letting them match all specific
// variants of the language.
// Examples:
// parse_accept_language("en", ["en-US", "fr-CA", "fr-FR"])
// returns: ["en-US"]
// parse_accept_language("fr", ["en-US", "fr-CA", "fr-FR"])
// returns: ["fr-CA", "fr-FR"]
// parse_accept_language("fr-FR, fr", ["en-US", "fr-CA", "fr-FR"])
// returns: ["fr-FR", "fr-CA"]

// Part 3
// Accept-Language headers will sometimes include a "wildcard" entry, represented
// by an asterisk, which means "all other languages". Extend your function to
// support the wildcard entry.
// Examples:
// parse_accept_language("en-US, *", ["en-US", "fr-CA", "fr-FR"])
// returns: ["en-US", "fr-CA", "fr-FR"]
// parse_accept_language("fr-FR, fr, *", ["en-US", "fr-CA", "fr-FR"])
// returns: ["fr-FR", "fr-CA", "en-US"]

import java.util.*;
import java.util.stream.Collectors;

public class AcceptLanguage {

    public List<String> solution(String acceptLanguageHeader, String[] supportedLanguages) {
        List<String> result = new ArrayList<>();

        String[] parsedAcceptLanguageHeader = acceptLanguageHeader.split(",");
        for (String acceptHeader: parsedAcceptLanguageHeader) {
            for (String language: supportedLanguages) {
                acceptHeader = acceptHeader.trim();
                language = language.trim();
                if (language.contains(acceptHeader)) {
                    if (acceptHeader.length()==2) result.add(language);
                    else
                        result.add(acceptHeader);
                } else {
                    if (acceptHeader.equals("*")) {
                        result.addAll(Arrays.asList(supportedLanguages));
                        break;
                    }
                }
            }
        }

        if (result.isEmpty()) result.add("en-US"); // default value
        return removeDuplicates(result);
    }

    private static List<String> removeDuplicates(List<String> results) {
        return new ArrayList<>(new LinkedHashSet<>(results));
    }
}
