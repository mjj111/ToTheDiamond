class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        uniqueEmails = set()

        for email in emails:
            cleanMail = []

            for currChar in email:
                if currChar == '+' or currChar == '@':
                    break

                if currChar != '.':
                    cleanMail.append(currChar)

            domainName = []
            for currChar in reversed(email):
                domainName.append(currChar)
                if currChar == '@':
                    break

            domainName = ''.join(domainName[::-1])
            cleanMail = ''.join(cleanMail)
            uniqueEmails.add(cleanMail + domainName)
            
        return len(uniqueEmails)